package fr.nikho.manhunt.world;

import fr.nikho.manhunt.exception.world.ManhuntWorldGeneratorException;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.WorldCreator;

public abstract class ManhuntWorld extends WorldCreator {

    private World world;

    public ManhuntWorld(String name) {
        super(name);
    }

    public void generate() {
        if (Bukkit.getWorld(name()) != null)
            throw new ManhuntWorldGeneratorException("World '" + name() + "' already exists !");
        this.world = Bukkit.createWorld(this);
    }

    public boolean isGenerated() {
        return world != null;
    }

    public void register() {
        WorldGenerator.addWorldToGenerate(this);
    }

}
