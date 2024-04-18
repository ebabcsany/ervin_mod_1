package net.minecraft.util.datafix.fixes;

import com.mojang.datafixers.schemas.Schema;

public class ModLevelDataGeneratorOptionsFix extends LevelDataGeneratorOptionsFix {
    ModLevelDataGeneratorOptionsFix(Schema outputSchema, boolean changesType) {
        super(outputSchema, changesType);
        field_210553_a.put("56", "ervin_mod:mig_biome");
    }
}
