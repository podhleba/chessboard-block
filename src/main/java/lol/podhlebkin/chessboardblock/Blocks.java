package lol.podhlebkin.chessboardblock;

import lol.podhlebkin.chessboardblock.ChessboardBlock;
import lol.podhlebkin.chessboardblock.Items;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Function;

public class Blocks {
    public static final DeferredRegister.Blocks BLOCKS =
            DeferredRegister.createBlocks(ChessboardBlock.MOD_ID);

    public static final DeferredBlock<Block> CHESSBOARD_BLOCK = registerBlock("chessboard_block",
            properties -> new Block(properties
                    .mapColor(DyeColor.LIGHT_GRAY).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops()
                    .strength(1.8F)));

    public static final DeferredBlock<Block> CHESSBOARD_STAIRS = registerBlock("chessboard_stairs",
            properties -> new StairBlock(Blocks.CHESSBOARD_BLOCK.get().defaultBlockState(),
                    properties.mapColor(DyeColor.LIGHT_GRAY).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops()
                    .strength(1.8F)));

    public static final DeferredBlock<Block> CHESSBOARD_SLAB = registerBlock("chessboard_slab",
            properties -> new SlabBlock(properties
                    .mapColor(DyeColor.LIGHT_GRAY).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops()
                            .strength(1.8F)));




    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Function<BlockBehaviour.Properties, T> function) {
        DeferredBlock<T> toReturn = BLOCKS.registerBlock(name, function);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block) {
        Items.ITEMS.registerItem(name, properties -> new BlockItem(block.get(), properties.useBlockDescriptionPrefix()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}