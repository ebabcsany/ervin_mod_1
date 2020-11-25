package com.babcsany.minecraft.ervin_mod_1.particles;

import com.mojang.brigadier.StringReader;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.minecraft.network.PacketBuffer;
import net.minecraft.particles.ParticleType;

public interface IParticleData1 {
   ParticleType<?> getType();

   void write(PacketBuffer buffer);

   String getParameters();

   @Deprecated
   public interface IDeserializer<T extends IParticleData1> {
      T deserialize(ParticleType1<T> particleTypeIn, StringReader reader) throws CommandSyntaxException;

      T read(ParticleType1<T> particleTypeIn, PacketBuffer buffer);
   }
}