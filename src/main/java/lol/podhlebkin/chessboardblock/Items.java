package lol.podhlebkin.chessboardblock;


import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.BannerPatternItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.entity.BannerPattern;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class Items {

    public static final TagKey<BannerPattern> PATTERN_ITEM_CHESSBOARD = TagKey.create(Registries.BANNER_PATTERN, ResourceLocation.fromNamespaceAndPath(ChessboardBlock.MOD_ID, "pattern_item/chessboard"));

    public static  final DeferredRegister.Items ITEMS = DeferredRegister.createItems(ChessboardBlock.MOD_ID);

    public static final DeferredItem<Item> CHESSBOARD_BANNER_PATTERN = ITEMS.register("chessboard_banner_pattern",
            () -> new BannerPatternItem(PATTERN_ITEM_CHESSBOARD, new Item.Properties().stacksTo(1)));


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
