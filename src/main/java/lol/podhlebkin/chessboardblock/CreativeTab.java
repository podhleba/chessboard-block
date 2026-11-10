package lol.podhlebkin.chessboardblock;

import net.fabricmc.fabric.api.creativetab.v1.CreativeModeTabEvents;
import net.fabricmc.fabric.api.creativetab.v1.FabricCreativeModeTab;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

public class CreativeTab {
    public static final CreativeModeTab CHESSBOARD_BLOCK = Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB,
            Identifier.fromNamespaceAndPath(ChessboardBlock.MOD_ID, "chessboard_block"),
            FabricCreativeModeTab.builder().icon(() -> new ItemStack(Blocks.CHESSBOARD_BLOCK))
                    .title(Component.translatable("creativetab.chessboard_block"))
                    .displayItems((parameters, output) -> {
                        output.accept(Blocks.CHESSBOARD_BLOCK);
                        output.accept(Blocks.CHESSBOARD_STAIRS);
                        output.accept(Blocks.CHESSBOARD_SLAB);
                        output.accept(Items.CHESSBOARD_BANNER_PATTERN);
                    }).build());

    public static void register() {
        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.INGREDIENTS).register(output -> {
            output.insertBefore(net.minecraft.world.item.Items.PIGLIN_BANNER_PATTERN, Items.CHESSBOARD_BANNER_PATTERN);
        });

        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.BUILDING_BLOCKS).register(output -> {
            output.insertBefore(net.minecraft.world.item.Items.AMETHYST_BLOCK, Blocks.CHESSBOARD_BLOCK);
            output.insertAfter(Blocks.CHESSBOARD_BLOCK, Blocks.CHESSBOARD_STAIRS);
            output.insertAfter(Blocks.CHESSBOARD_STAIRS, Blocks.CHESSBOARD_SLAB);
        });
    }
}