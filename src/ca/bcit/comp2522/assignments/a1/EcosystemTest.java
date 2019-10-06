package ca.bcit.comp2522.assignments.a1;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.Random;

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
    public void testSimulateOneWeekPopulationIsChanging() {
        Ecosystem ecosystem = new Ecosystem();
        ecosystem.setupSimulation();
        int ecosystemInitialPopulation = ecosystem.getGuppyPopulation();
        ecosystem.simulateOneWeek();
        int ecosystemPopulationAfterOneWeek = ecosystem.getGuppyPopulation();
        assertTrue(ecosystemInitialPopulation != ecosystemPopulationAfterOneWeek);
    }

    @Test
    public void testSetupSimulationCreatesPoolNamedSemiahmoo() {
        Ecosystem ecosystem = new Ecosystem();
        ecosystem.setupSimulation();
        boolean SemiahmooPoolFound = false;
        for (Pool pool : ecosystem.getPools()) {
            if (pool.getName().equals("Semiahmoo")) {
                SemiahmooPoolFound = true;
                break;
            }
        }
        assertTrue(SemiahmooPoolFound);
    }

    @Test
    public void testSetupSimulationCreatesPoolNamedSquamish() {
        Ecosystem ecosystem = new Ecosystem();
        ecosystem.setupSimulation();
        boolean squamishPoolFound = false;
        for (Pool pool : ecosystem.getPools()) {
            if (pool.getName().equals("Squamish")) {
                squamishPoolFound = true;
                break;
            }
        }
        assertTrue(squamishPoolFound);
    }

    @Test
    public void testSetupSimulationCreatesPoolNamedSkookumchuk() {
        Ecosystem ecosystem = new Ecosystem();
        ecosystem.setupSimulation();
        boolean skookumchukPoolFound = false;
        for (Pool pool : ecosystem.getPools()) {
            if (pool.getName().equals("Skookumchuk")) {
                skookumchukPoolFound = true;
                break;
            }
        }
        assertTrue(skookumchukPoolFound);
    }

    @Test
    public void testSetupSimulationTotalPopulationIsCorrect() {
        Ecosystem ecosystem = new Ecosystem();
        ecosystem.setupSimulation();
        assertEquals(ecosystem.getGuppyPopulation(), 600);
    }

    @Test
    public void testSetupSimulationCreatesThreePools() {
        Ecosystem ecosystem = new Ecosystem();
        ecosystem.setupSimulation();
        assertEquals(ecosystem.getPools().size(), 3);
    }

    @Test
    public void testSpawnReturnsCorrectAmount() {
        Random rand = new Random();
        Ecosystem ecosystem = new Ecosystem();
        Pool pool = new Pool("Test",
                500.0,
                40.0,
                7.0,
                0.25);

        for (int i = 0; i < 150; i++) {
            Guppy guppy = new Guppy(Guppy.DEFAULT_GENUS,
                    Guppy.DEFAULT_SPECIES,
                    rand.nextInt(40),
                    true,
                    0,
                    0.5);
            pool.addGuppy(guppy);
        }
        ecosystem.addPool(pool);
        int newFry = ecosystem.spawn();
        assertEquals( pool.getPopulation(), 150 + newFry);
    }

    @Test
    public void testApplyNutrientCoefficientReturnsCorrectAmount() {
        Random rand = new Random();
        Ecosystem ecosystem = new Ecosystem();
        Pool pool = new Pool("Test",
                500.0,
                40.0,
                7.0,
                0.25);

        for (int i = 0; i < 150; i++) {
            Guppy guppy = new Guppy(Guppy.DEFAULT_GENUS,
                    Guppy.DEFAULT_SPECIES,
                    rand.nextInt(40),
                    Double.compare(rand.nextDouble(), 0.35) < 0,
                    0,
                    rand.nextDouble());
            pool.addGuppy(guppy);
        }
        ecosystem.addPool(pool);
        int deadGuppies = ecosystem.applyNutrientCoefficient();
        assertEquals( pool.getPopulation(), 150 - deadGuppies);
    }

    @Test
    public void testRemoveDeadGuppies() {
        Ecosystem ecosystem = new Ecosystem();
        Pool pool = new Pool("Test",
                500.0,
                40.0,
                7.0,
                0.5);

        for (int i = 0; i < 100; i++) {
            pool.addGuppy(new Guppy(Guppy.DEFAULT_GENUS,
                    Guppy.DEFAULT_SPECIES,
                    i,
                    true,
                    0,
                    0.5)
            );
        }

        for(int i = 0; i < 50; i ++) {
            pool.getGuppiesInPool().get(i).setIsAlive(false); // set 50 guppies to not be alive
        }
        ecosystem.addPool(pool);
        assertEquals(ecosystem.removeDeadGuppies(), 50);
    }
    @Test
    public void testIncrementAges() {
        Ecosystem ecosystem = new Ecosystem();
        Pool pool = new Pool("Test",
                500.0,
                40.0,
                7.0,
                0.5);

        for (int i = 0; i < 100; i++) {
            pool.addGuppy(new Guppy(Guppy.DEFAULT_GENUS,
                    Guppy.DEFAULT_SPECIES,
                    i,
                    true,
                    0,
                    0.5)
            );
        }
        ecosystem.addPool(pool);
        assertEquals(ecosystem.incrementAges(), 50);
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
    public void testGetPoolsReturnsAllPoolsCorrectly()  {
        Ecosystem ecosystem = new Ecosystem();
        Pool pool1 = new Pool();
        Pool pool2 = new Pool();
        ecosystem.addPool(pool1);
        ecosystem.addPool(pool2);
        int i = 0;
        assertEquals(ecosystem.getPools().get(0), pool1);
        assertEquals(ecosystem.getPools().get(1), pool2);
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
