package lol.podhlebkin.chessboardblock;


import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.tags.BannerPatternTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.entity.BannerPattern;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class Items {

    public static final TagKey<BannerPattern> PATTERN_ITEM_CHESSBOARD = TagKey.create(Registries.BANNER_PATTERN, Identifier.fromNamespaceAndPath(ChessboardBlock.MOD_ID, "pattern_item/chessboard"));

    public static  final DeferredRegister.Items ITEMS = DeferredRegister.createItems(ChessboardBlock.MOD_ID);


    public static final DeferredItem<Item> CHESSBOARD_BANNER_PATTERN = ITEMS.registerItem("chessboard_banner_pattern", properties ->
            new Item(properties.stacksTo(1)
                    .delayedComponent(DataComponents.PROVIDES_BANNER_PATTERNS, context -> context.getOrThrow(PATTERN_ITEM_CHESSBOARD))));


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
