package ca.bcit.comp2522.assignments.a1;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

public class EcosystemTest {

    private Ecosystem defaultEcosystem;
    private Pool defaultPool;

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @org.junit.Before
    public void setUp() throws Exception {
        defaultEcosystem = new Ecosystem();
        defaultPool = new Pool();
    }

    @Test
    public void testAddPool() {
        Ecosystem ecosystem = new Ecosystem();
        ecosystem.addPool(defaultPool);
        assertEquals(ecosystem.getPools().size(), 1);
    }

    @Test
    public void testAddNullPoolDoesNothing() {
        Ecosystem ecosystem = new Ecosystem();
        ecosystem.addPool(null);
        assertEquals(ecosystem.getPools().size(), 0);
    }

    @Test
    public void testReset() {
        Ecosystem ecosystem = new Ecosystem();
        ecosystem.addPool(new Pool());
        ecosystem.addPool(new Pool());
        ecosystem.reset();
        assertEquals(ecosystem.getPools().size(), 0);
    }

    @Test
    public void testGetGuppyPopulation() {
        Ecosystem ecosystem = new Ecosystem();
        Pool pool = new Pool();
        int guppyPopulation = 100;
        for (int i = 0; i < guppyPopulation; i++) {
            pool.addGuppy(new Guppy(Guppy.DEFAULT_GENUS,
                    Guppy.DEFAULT_SPECIES,
                    0,
                    true,
                    0,
                    0.5)
            );
        }
        ecosystem.addPool(pool);
        assertEquals(ecosystem.getGuppyPopulation(), guppyPopulation);
    }

    @Test
    public void testGetGuppyPopulationMultiplePools() {
        Ecosystem ecosystem = new Ecosystem();
        Pool pool = new Pool();
        Pool otherPool = new Pool();
        int guppyPopulationFirstPool = 100;
        int guppyPopulationSecondPool = 250;
        int guppyPopulation = guppyPopulationFirstPool + guppyPopulationSecondPool;

        for (int i = 0; i < guppyPopulationFirstPool; i++) {
            pool.addGuppy(new Guppy(Guppy.DEFAULT_GENUS,
                    Guppy.DEFAULT_SPECIES,
                    0,
                    true,
                    0,
                    0.5)
            );
        }
        for (int i = 0; i < guppyPopulationSecondPool; i++) {
            otherPool.addGuppy(new Guppy(Guppy.DEFAULT_GENUS,
                    Guppy.DEFAULT_SPECIES,
                    0,
                    true,
                    0,
                    0.5)
            );
        }
        ecosystem.addPool(pool);
        ecosystem.addPool(otherPool);
        assertEquals(ecosystem.getGuppyPopulation(), guppyPopulation);
    }

    @Test
    public void testAdjustForCrowding() {
        Ecosystem ecosystem = new Ecosystem();
        Pool pool = new Pool("Test",
                500.0,
                40.0,
                7.0,
                0.5);

        for (int i = 0; i < 1000; i++) {
            pool.addGuppy(new Guppy(Guppy.DEFAULT_GENUS,
                    Guppy.DEFAULT_SPECIES,
                    30,
                    true,
                    0,
                    0.5)
            );
        }
        ecosystem.addPool(pool);
        ecosystem.adjustForCrowding();
        assertTrue(Double.compare(pool.getGuppyVolumeRequirementInLitres(),
                pool.getVolumeLitres()) <= 0);

    }
    @Test
    public void testAdjustForCrowdingWithMultiplePools() {
        Ecosystem ecosystem = new Ecosystem();
        Pool pool = new Pool("Test",
                500.0,
                40.0,
                7.0,
                0.5);
        Pool otherPool = new Pool("Test",
                500.0,
                40.0,
                7.0,
                0.5);
        for (int i = 0; i < 1000; i++) {
            pool.addGuppy(new Guppy(Guppy.DEFAULT_GENUS,
                    Guppy.DEFAULT_SPECIES,
                    30,
                    true,
                    0,
                    0.5)
            );
        }
        for (int i = 0; i < 1000; i++) {
            otherPool.addGuppy(new Guppy(Guppy.DEFAULT_GENUS,
                    Guppy.DEFAULT_SPECIES,
                    30,
                    true,
                    0,
                    0.5)
            );
        }
        ecosystem.addPool(pool);
        ecosystem.addPool(otherPool);
        ecosystem.adjustForCrowding();
        for (Pool poolInEcosystem : ecosystem.getPools()) {
            assertTrue(Double.compare(poolInEcosystem.getGuppyVolumeRequirementInLitres(),
                    poolInEcosystem.getVolumeLitres()) <= 0);
        }
    }


}
