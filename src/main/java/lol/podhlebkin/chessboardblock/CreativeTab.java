package lol.podhlebkin.chessboardblock;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class CreativeTab {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, ChessboardBlock.MOD_ID);

    public static final Supplier<CreativeModeTab> CHESSBOARD_BLOCK = CREATIVE_MODE_TAB.register("chessboard_block",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(Blocks.CHESSBOARD_BLOCK.get())).title(Component.translatable("creativetab.chessboard_block"))
                    .displayItems((parameters, output) -> {
                        output.accept(Blocks.CHESSBOARD_BLOCK);
                        output.accept(Blocks.CHESSBOARD_STAIRS);
                        output.accept(Blocks.CHESSBOARD_SLAB);
                        output.accept(Items.CHESSBOARD_BANNER_PATTERN);
                    }).build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TAB.register(eventBus);
    }
}
