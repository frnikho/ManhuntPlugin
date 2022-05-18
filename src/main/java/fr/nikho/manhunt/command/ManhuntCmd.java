package fr.nikho.manhunt.command;

import fr.nikho.manhunt.world.WorldGenerator;
import fr.nikho.manhunt.world.worlds.Overworld;
import io.reactivex.rxjava3.annotations.NonNull;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ManhuntCmd implements CommandExecutor {
    @Override
    public boolean onCommand(@NonNull CommandSender sender, @NonNull Command cmd, @NonNull String label, @NonNull String[] args) {
        Player p = (Player) sender;
        new Overworld().register();
        new WorldGenerator().generateWorld();
        return true;
    }
}
