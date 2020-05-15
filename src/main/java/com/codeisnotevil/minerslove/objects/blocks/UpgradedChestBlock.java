package com.codeisnotevil.minerslove.objects.blocks;

import com.codeisnotevil.minerslove.init.ModTileEntityTypes;
import com.codeisnotevil.minerslove.tileentities.UpgradedChestTileEntity;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkHooks;

import javax.annotation.Nonnull;

public class UpgradedChestBlock extends Block {

    public UpgradedChestBlock(Properties properties) {
        super(properties);
    }

    @Override
    public boolean hasTileEntity(BlockState state) {
        return true;
    }


    @Override
    public TileEntity createTileEntity(BlockState state, IBlockReader world) {
        return ModTileEntityTypes.UPGRADED_CHEST_TILE_ENTITY.get().create();
    }

    @Nonnull
    @Override
    public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player,
                                             Hand handIn, BlockRayTraceResult hit) {
        if(!worldIn.isRemote) {
            TileEntity tile = worldIn.getTileEntity(pos);
            NetworkHooks.openGui((ServerPlayerEntity) player, (UpgradedChestTileEntity) tile, pos);
            return ActionResultType.SUCCESS;
        }
        return ActionResultType.FAIL;
    }

    @Nonnull
    @Override
    public void onReplaced(BlockState state, World worldIn, BlockPos pos, BlockState newState, boolean isMoving) {
        if(state.getBlock() != newState.getBlock()){
            TileEntity tile = worldIn.getTileEntity(pos);
            if(tile instanceof UpgradedChestTileEntity){
                InventoryHelper.dropItems(worldIn, pos, ((UpgradedChestTileEntity) tile).getItems());
            }
        }
    }
}
