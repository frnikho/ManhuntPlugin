package fr.nikho.manhunt.world;

import fr.nikho.manhunt.exception.world.ManhuntWorldGeneratorException;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;

import java.util.ArrayList;
import java.util.Optional;

public class WorldGenerator {

    private static final ArrayList<ManhuntWorld> worldToGenerate = new ArrayList<>();

    public WorldGenerator() {

    }

    public static void addWorldToGenerate(ManhuntWorld world) {
        if (worldToGenerate.stream().anyMatch((w) -> w.name().equalsIgnoreCase(world.name()))) {
            throw new ManhuntWorldGeneratorException("World '" + world.name() + "' is already registered");
        }
        WorldGenerator.worldToGenerate.add(world);
    }

    public static void removeWorldToGenerate(String worldName) {
        Optional<ManhuntWorld> world = worldToGenerate.stream().filter((w) -> w.name().equalsIgnoreCase(worldName)).findFirst();
        world.ifPresent(worldToGenerate::remove);
    }

    public void generateWorld() {
        Observable.fromIterable(worldToGenerate).subscribe(new Observer<>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {
                System.out.println("Subscribe");
            }

            @Override
            public void onNext(@NonNull ManhuntWorld manhuntWorld) {
                manhuntWorld.generate();
            }

            @Override
            public void onError(@NonNull Throwable e) {
                System.out.println("Error" + e);
            }

            @Override
            public void onComplete() {
                System.out.println("Complete");
            }
        });
    }

}
