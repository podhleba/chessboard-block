package lol.podhlebkin.chessboardblock;


import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class CreativeTab {

    public static final ItemGroup CHESSBOARD_BLOCK = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(ChessboardBlock.MOD_ID, "chessboard_block"),
            FabricItemGroup.builder().icon(() -> new ItemStack(Blocks.CHESSBOARD_BLOCK))
                    .displayName(Text.translatable("creativetab.chessboard_block"))
                    .entries((displayContext, entries) -> {
                        entries.add(Blocks.CHESSBOARD_BLOCK);
                        entries.add(Blocks.CHESSBOARD_STAIRS);
                        entries.add(Blocks.CHESSBOARD_SLAB);
                        entries.add(Items.CHESSBOARD_BANNER_PATTERN);
                    }).build());

    public static void register() {
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
            entries.addBefore(net.minecraft.item.Items.PIGLIN_BANNER_PATTERN, Items.CHESSBOARD_BANNER_PATTERN);
        });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(entries -> {
            entries.addBefore(net.minecraft.item.Items.AMETHYST_BLOCK, Blocks.CHESSBOARD_BLOCK);
            entries.addAfter(Blocks.CHESSBOARD_BLOCK, Blocks.CHESSBOARD_STAIRS);
            entries.addAfter(Blocks.CHESSBOARD_STAIRS, Blocks.CHESSBOARD_SLAB);
        });
    }
}
