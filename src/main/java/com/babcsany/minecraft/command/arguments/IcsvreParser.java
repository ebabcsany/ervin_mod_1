package com.babcsany.minecraft.command.arguments;

import com.babcsany.minecraft.ervin_mod_1.item.item.icsvre.Icsvre;
import com.google.common.collect.Maps;
import com.mojang.brigadier.StringReader;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.exceptions.DynamicCommandExceptionType;
import com.mojang.brigadier.exceptions.SimpleCommandExceptionType;
import com.mojang.brigadier.suggestion.Suggestions;
import com.mojang.brigadier.suggestion.SuggestionsBuilder;
import net.minecraft.command.ISuggestionProvider;
import net.minecraft.item.Item;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.JsonToNBT;
import net.minecraft.state.Property;
import net.minecraft.tags.TagCollection;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.text.TranslationTextComponent;

import javax.annotation.Nullable;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.function.BiFunction;

public class IcsvreParser {
   public static final SimpleCommandExceptionType ICSVRE_TAGS_NOT_ALLOWED = new SimpleCommandExceptionType(new TranslationTextComponent("argument.item.tag.disallowed"));
   public static final DynamicCommandExceptionType ICSVRE_BAD_ID = new DynamicCommandExceptionType((object) -> new TranslationTextComponent("argument.item.id.invalid", object));
   private static final BiFunction<SuggestionsBuilder, TagCollection<Icsvre>, CompletableFuture<Suggestions>> DEFAULT_SUGGESTIONS_BUILDER = (p_239571_0_, p_239571_1_) -> p_239571_0_.buildFuture();
   private final StringReader reader;
   private final boolean allowTags;
   private final Map<Property<?>, Comparable<?>> field_197336_d = Maps.newHashMap();
   private Item item;
   private Icsvre icsvre;
   @Nullable
   private CompoundNBT nbt;
   private ResourceLocation tag = new ResourceLocation("");
   private int readerCursor;
   /** Builder to be used when creating a list of suggestions */
   private BiFunction<SuggestionsBuilder, TagCollection<Icsvre>, CompletableFuture<Suggestions>> suggestionsBuilder = DEFAULT_SUGGESTIONS_BUILDER;

   public IcsvreParser(StringReader readerIn, boolean allowTags) {
      this.reader = readerIn;
      this.allowTags = allowTags;
   }

   public Icsvre getIcsvre() {
      return this.icsvre;
   }

   @Nullable
   public CompoundNBT getNbt() {
      return this.nbt;
   }

   public ResourceLocation getTag() {
      return this.tag;
   }

   public void readIcsvre() throws CommandSyntaxException {
      int i = this.reader.getCursor();
      ResourceLocation resourcelocation = ResourceLocation.read(this.reader);
      this.item = Registry.ITEM.getValue(resourcelocation).orElseThrow(() -> {
         this.reader.setCursor(i);
         return ICSVRE_BAD_ID.createWithContext(this.reader, resourcelocation.toString());
      });
   }

   public void readTag() throws CommandSyntaxException {
      if (!this.allowTags) {
         throw ICSVRE_TAGS_NOT_ALLOWED.create();
      } else {
         this.suggestionsBuilder = this::suggestTag;
         this.reader.expect('#');
         this.readerCursor = this.reader.getCursor();
         this.tag = ResourceLocation.read(this.reader);
      }
   }

   public void readNBT() throws CommandSyntaxException {
      this.nbt = (new JsonToNBT(this.reader)).readStruct();
   }

   public IcsvreParser parse() throws CommandSyntaxException {
      this.suggestionsBuilder = this::suggestTagOrIcsvre;
      if (this.reader.canRead() && this.reader.peek() == '#') {
         this.readTag();
      } else {
         this.readIcsvre();
         this.suggestionsBuilder = this::suggestIcsvre;
      }

      if (this.reader.canRead() && this.reader.peek() == '{') {
         this.suggestionsBuilder = DEFAULT_SUGGESTIONS_BUILDER;
         this.readNBT();
      }

      return this;
   }

   /**
    * Builds a list of suggestions based on icsvre registry names.
    */
   private CompletableFuture<Suggestions> suggestIcsvre(SuggestionsBuilder builder, TagCollection<Icsvre> p_197328_2_) {
      if (builder.getRemaining().isEmpty()) {
         builder.suggest(String.valueOf('{'));
      }

      return builder.buildFuture();
   }

   /**
    * Builds a list of suggestions based on icsvre tags.
    */
   private CompletableFuture<Suggestions> suggestTag(SuggestionsBuilder builder, TagCollection<Icsvre> p_201955_2_) {
      return ISuggestionProvider.suggestIterable(p_201955_2_.getRegisteredTags(), builder.createOffset(this.readerCursor));
   }

   /**
    * Builds a list of suggestions based on item tags (if the parser is set to allows tags) and icsvre registry names.
    */
   private CompletableFuture<Suggestions> suggestTagOrIcsvre(SuggestionsBuilder builder, TagCollection<Icsvre> p_197331_2_) {
      if (this.allowTags) {
         ISuggestionProvider.suggestIterable(p_197331_2_.getRegisteredTags(), builder, String.valueOf('#'));
      }

      return ISuggestionProvider.suggestIterable(Registry.ITEM.keySet(), builder);
   }

   /**
    * Create a list of suggestions for the specified builder.
    */
   public CompletableFuture<Suggestions> fillSuggestions(SuggestionsBuilder builder, TagCollection<Icsvre> p_197329_2_) {
      return this.suggestionsBuilder.apply(builder.createOffset(this.reader.getCursor()), p_197329_2_);
   }
}
