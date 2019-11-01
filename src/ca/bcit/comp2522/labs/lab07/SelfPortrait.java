package ca.bcit.comp2522.labs.lab07;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.transform.Shear;
import javafx.stage.Stage;

/**
 *Creates a Self portrait of myself with a background and painting.
 *
 * @author Tommy May
 * @version 2019
 */
public class SelfPortrait extends Application {

    /**
     * Creates and returns a group for my face.
     *
     * @return a Group
     */
    private Group createFace() {
        Ellipse head = new Ellipse(80, 70, 30, 36);
        head.setFill(Color.TAN);

        Circle rightEye = new Circle(70, 60, 5);

        Circle leftEye = new Circle(90, 60, 5);

        Line mouth = new Line(51, 75, 109, 75);
        mouth.setStrokeWidth(2);

        return new Group(head, rightEye, leftEye, mouth);
    }

    /**
     * Creates and returns a group for my glasses.
     *
     * @return a Group
     */
    private Group createGlasses() {
        Group leftHalf = createGlassesRim();

        Group rightHalf = createGlassesRim();
        rightHalf.setScaleX(-1);
        rightHalf.setTranslateX(27);

        Line center = new Line(78, 60, 80, 60);
        center.setStrokeWidth(2);

        return new Group(leftHalf, rightHalf, center);
    }

    /**
     * Creates one rim for glasses.
     *
     * @return a Group
     */
    private Group createGlassesRim() {
        Line line = new Line(54, 52, 62, 58);
        Rectangle rim = new Rectangle(62, 53, 16, 14);
        rim.setFill(Color.TRANSPARENT);
        rim.setStroke(Color.BLACK);
        rim.setStrokeWidth(1);
        return new Group(line, rim);
    }

    /**
     * Creates and returns a group for my hair.
     *
     * @return a Group
     */
    private Group createHair() {
        Rectangle hairpiece = new Rectangle(50, 20, 20, 10);
        hairpiece.getTransforms().add(new Shear(0.6, 0.2));
        hairpiece.setRotate(6);
        hairpiece.setFill(Color.rgb(133, 87, 13));

        Rectangle hairpiece2 = new Rectangle(60, 17, 17, 10);
        hairpiece2.getTransforms().add(new Shear(0.6, 0.2));
        hairpiece2.setRotate(6);
        hairpiece2.setFill(Color.rgb(133, 87, 13));

        Rectangle hairpiece3 = new Rectangle(70, 16, 14, 10);
        hairpiece3.getTransforms().add(new Shear(0.6, 0.2));
        hairpiece3.setRotate(2);
        hairpiece3.setFill(Color.rgb(133, 87, 13));

        return new Group(hairpiece, hairpiece2, hairpiece3);
    }

    /**
     * Creates and returns a group for my left arm.
     *
     * @return a Group
     */
    private Group createLeftArm() {
        Line leftArm1 = new Line(100, 110, 115, 130);
        leftArm1.setStrokeWidth(8);
        leftArm1.setStroke(Color.rgb(83, 72, 11));

        Line leftArm2 = new Line(115, 130, 115, 160);
        leftArm2.setStrokeWidth(8);
        leftArm2.setStroke(Color.rgb(83, 72, 11));

        Rectangle leftHand = new Rectangle(109, 160, 12, 12);
        leftHand.setFill(Color.TAN);
        leftHand.setRotate(30);

        return new Group(leftArm1, leftArm2, leftHand);
    }

    /**
     * Creates and returns a group for my right arm.
     *
     * @return a Group
     */
    private Group createRightArm() {
        Line rightArm1 = new Line(60, 110, 45, 130);
        rightArm1.setStrokeWidth(8);
        rightArm1.setStroke(Color.rgb(83, 72, 11));

        Line rightArm2 = new Line(45, 130, 45, 160);
        rightArm2.setStrokeWidth(8);
        rightArm2.setStroke(Color.rgb(83, 72, 11));

        Rectangle rightHand = new Rectangle(39, 160, 12, 12);
        rightHand.setFill(Color.TAN);
        rightHand.setRotate(-30);

        return new Group(rightArm1, rightArm2, rightHand);
    }

    /**
     * Creates and returns a group for my left leg.
     *
     * @return a Group
     */
    private Group createLeftLeg() {
        Line leftLeg = new Line(95, 185, 105, 235);
        leftLeg.setStrokeWidth(8);

        Rectangle leftFoot = new Rectangle(101, 235, 20, 6);
        leftFoot.setFill(Color.GRAY);

        return new Group(leftLeg, leftFoot);
    }

    /**
     * Creates and returns a group for my right leg.
     *
     * @return a Group
     */
    private Group createRightLeg() {
        Line rightLeg = new Line(95, 185, 105, 235);
        rightLeg.setStrokeWidth(8);

        Rectangle rightFoot = new Rectangle(101, 235, 20, 6);
        rightFoot.setFill(Color.GRAY);

        Group fullRightLeg = new Group(rightLeg, rightFoot);
        fullRightLeg.setTranslateX(-50);
        fullRightLeg.setScaleX(-1);
        return fullRightLeg;
    }

    /**
     * Creates and returns a group for my body.
     *
     * @return a Group
     */
    private Group createBody() {
        Rectangle body = new Rectangle(57.5, 100, 45, 85);
        body.setFill(Color.rgb(83, 72, 11));

        Rectangle letterTop = new Rectangle(10, 120, 20, 5);
        letterTop.getTransforms().add(new Shear(0.5, 0));
        letterTop.setFill(Color.BLACK);

        Rectangle letterBottom = new Rectangle(78, 125, 5, 20);
        letterBottom.setFill(Color.BLACK);

        return new Group(body, letterTop, letterBottom);
    }

    /**
     * Creates and returns a group for an image.
     *
     * @return a Group
     */
    private Group createImage() {
        Image image = new Image("image1.png");
        ImageView imageView = new ImageView(image);
        imageView.setFitWidth(96);
        imageView.setFitHeight(56);
        imageView.setX(92);
        imageView.setY(102);
        return new Group(imageView);
    }

    /**
     * Creates and returns a group for the painting frame.
     *
     * @return a Group
     */
    private Group createPainting() {
        Rectangle frame = new Rectangle(90, 100, 100, 60);
        frame.setFill(Color.TRANSPARENT);
        frame.setStrokeWidth(4);
        frame.setStroke(Color.BURLYWOOD);

        Line wireLeft = new Line(90, 100, 140, 50);

        Line wireRight = new Line(190, 100, 140, 50);

        Circle nail = new Circle(140, 50, 5);
        nail.setFill(Color.GRAY);

        return new Group(frame, wireLeft, wireRight, nail);
    }
    /**
     * Creates and displays a self portrait of myself with a background and painting.
     *
     * @param primaryStage contains the Scene
     */
    public void start(Stage primaryStage) {

        // Creating background
        Rectangle ground = new Rectangle(0, 250, 500, 100);
        ground.setFill(Color.BURLYWOOD);

        // creating painting
        Group painting = createPainting();

        // Creating image
        Group imageGroup = createImage();

        // Creating face
        Group face = createFace();

        // Creating glasses
        Group glasses = createGlasses();

        // Creating hair
        Group hair = createHair();

        // Creating body
        Group body = createBody();

        // Creating left arm
        Group leftArm = createLeftArm();

        // Creating right arm
        Group rightArm = createRightArm();

        // Creating left leg
        Group fullLeftLeg = createLeftLeg();

        // Creating right leg
        Group fullRightLeg = createRightLeg();

        // Creating tommy
        Group tommy = new Group(leftArm, rightArm, fullLeftLeg, fullRightLeg,
                body, face, glasses, hair);
        tommy.setTranslateX(170);
        tommy.setTranslateY(50);

        // creating root
        Group root = new Group(ground, painting, imageGroup, tommy);
        Scene scene = new Scene(root, 500, 350, Color.LIGHTBLUE);

        primaryStage.setTitle("Tommy");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * Launches the JavaFX application.
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}

