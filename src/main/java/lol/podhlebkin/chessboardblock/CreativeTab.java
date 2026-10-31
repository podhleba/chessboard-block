package lol.podhlebkin.chessboardblock;


import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
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

    public static void register() {}
}
