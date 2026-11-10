package lol.podhlebkin.chessboardblock;


import net.fabricmc.fabric.api.creativetab.v1.CreativeModeTabEvents;
import net.minecraft.core.Registry;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.BannerPatternTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.entity.BannerPattern;

import java.util.function.Function;

public class Items {

    public static final TagKey<BannerPattern> PATTERN_ITEM_CHESSBOARD = TagKey.create(Registries.BANNER_PATTERN, Identifier.fromNamespaceAndPath(ChessboardBlock.MOD_ID, "pattern_item/chessboard"));

    public static final Item CHESSBOARD_BANNER_PATTERN = registerItem("chessboard_banner_pattern", properties -> new Item(properties.stacksTo(1).delayedComponent(DataComponents.PROVIDES_BANNER_PATTERNS, context -> context.getOrThrow(
            PATTERN_ITEM_CHESSBOARD))));

    private static Item registerItem(String name, Function<Item.Properties, Item> function) {
        return Registry.register(BuiltInRegistries.ITEM, Identifier.fromNamespaceAndPath(ChessboardBlock.MOD_ID, name),
                function.apply(new Item.Properties().setId(ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(ChessboardBlock.MOD_ID, name)))));
    }

    public static void register() {
    }
}
