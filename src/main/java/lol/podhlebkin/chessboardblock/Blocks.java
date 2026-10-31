package lol.podhlebkin.chessboardblock;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import lol.podhlebkin.chessboardblock.ChessboardBlock;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.enums.NoteBlockInstrument;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.DyeColor;
import net.minecraft.util.Identifier;

public class Blocks {
    public static final Block CHESSBOARD_BLOCK = registerBlock("chessboard_block",
             new Block(AbstractBlock.Settings.create()
                     .mapColor(DyeColor.LIGHT_GRAY).instrument(NoteBlockInstrument.BASEDRUM).requiresTool().strength(1.8F)));


    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(ChessboardBlock.MOD_ID, name), block);
    }

    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, Identifier.of(ChessboardBlock.MOD_ID, name),
                new BlockItem(block, new Item.Settings()));
    }

    public static void register() {}
}