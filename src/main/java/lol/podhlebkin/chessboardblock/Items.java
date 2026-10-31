package lol.podhlebkin.chessboardblock;

import net.minecraft.block.entity.BannerPattern;
import net.minecraft.item.BannerPatternItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.BannerPatternTags;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class Items {
    public static final TagKey<BannerPattern> CHESSBOARD_PATTERN_ITEM = TagKey.of(RegistryKeys.BANNER_PATTERN, Identifier.of(ChessboardBlock.MOD_ID, "pattern_item/chessboard"));

    public static final Item CHESSBOARD_BANNER_PATTERN = registerItem("chessboard_banner_pattern",
            new BannerPatternItem(CHESSBOARD_PATTERN_ITEM, new Item.Settings().maxCount(1)));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(ChessboardBlock.MOD_ID, name), item);
    }

    public static void register() {
    }
}
