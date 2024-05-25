package com.babcsany.minecraft.ervin_mod_1.world.biome.provider;

import com.babcsany.minecraft.ervin_mod_1.Ervin_mod_1;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.mojang.serialization.Codec;
import com.mojang.serialization.DataResult;
import com.mojang.serialization.JsonOps;
import net.minecraft.data.BiomeProvider;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.DirectoryCache;
import net.minecraft.data.IDataProvider;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.biome.Biome;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Supplier;

public class ModBiomeProvider extends BiomeProvider {
    private static final Logger LOGGER = LogManager.getLogger();
    private static final Gson GSON = (new GsonBuilder()).setPrettyPrinting().create();
    private final DataGenerator generator;

    public ModBiomeProvider(DataGenerator generator) {
        super(generator);
        this.generator = generator;
    }

    /**
     * Performs this provider's action.
     */
    public void act(DirectoryCache cache) {
        Path path = this.generator.getOutputFolder();

        for(Map.Entry<RegistryKey<Biome>, Biome> entry : WorldGenRegistries.BIOME.getEntries()) {
            Path path1 = getPath(path, entry.getKey().getLocation());
            Biome biome = entry.getValue();
            Function<Supplier<Biome>, DataResult<JsonElement>> function = JsonOps.INSTANCE.withEncoder(Biome.BIOME_CODEC);

            try {
                Optional<JsonElement> optional = function.apply(() -> {
                    return biome;
                }).result();
                if (optional.isPresent()) {
                    IDataProvider.save(GSON, cache, optional.get(), path1);
                } else {
                    LOGGER.error("Couldn't serialize biome {}", (Object)path1);
                }
            } catch (IOException ioexception) {
                LOGGER.error("Couldn't save biome {}", path1, ioexception);
            }
        }

    }

    private static Path getPath(Path path, ResourceLocation biomeLocation) {
        return path.resolve("reports/biomes/" + biomeLocation.getPath() + ".json");
    }

    /**
     * Gets a name for this provider, to use in logging.
     */
    public String getName() {
        return "Biomes";
    }

    public static void register() {
        Registry.register(Registry.BIOME_PROVIDER_CODEC, Ervin_mod_1.identifier("example"), ExampleBiomeProvider.CODEC);
    }
}
