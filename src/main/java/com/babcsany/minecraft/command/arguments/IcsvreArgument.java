package com.babcsany.minecraft.command.arguments;

import com.mojang.brigadier.StringReader;
import com.mojang.brigadier.arguments.ArgumentType;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.suggestion.Suggestions;
import com.mojang.brigadier.suggestion.SuggestionsBuilder;
import net.minecraft.command.arguments.ItemInput;
import net.minecraft.command.arguments.ItemParser;
import net.minecraft.tags.ItemTags;

import java.util.Arrays;
import java.util.Collection;
import java.util.concurrent.CompletableFuture;

public class IcsvreArgument implements ArgumentType<IcsvreInput> {
   private static final Collection<String> EXAMPLES = Arrays.asList("stick", "minecraft:stick", "stick{foo=bar}");

   public static IcsvreArgument item() {
      return new IcsvreArgument();
   }

   public IcsvreInput parse(StringReader p_parse_1_) throws CommandSyntaxException {
      IcsvreParser icsvreParser = (new IcsvreParser(p_parse_1_, false)).parse();
      return new IcsvreInput(icsvreParser.getIcsvre(), icsvreParser.getNbt());
   }

   public static <S> IcsvreInput getItem(CommandContext<S> context, String name) {
      return context.getArgument(name, IcsvreInput.class);
   }

   public <S> CompletableFuture<Suggestions> listSuggestions(CommandContext<S> p_listSuggestions_1_, SuggestionsBuilder p_listSuggestions_2_) {
      StringReader stringreader = new StringReader(p_listSuggestions_2_.getInput());
      stringreader.setCursor(p_listSuggestions_2_.getStart());
      ItemParser itemparser = new ItemParser(stringreader, false);

      try {
         itemparser.parse();
      } catch (CommandSyntaxException commandsyntaxexception) {
      }

      return itemparser.fillSuggestions(p_listSuggestions_2_, ItemTags.getCollection());
   }

   public Collection<String> getExamples() {
      return EXAMPLES;
   }
}
