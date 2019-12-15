package userInterface;

import controller.Deleter;
import controller.Scheduler;
import javafx.animation.*;
import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.effect.Bloom;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Glow;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.GridPane;
import javafx.scene.media.AudioClip;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.CullFace;
import javafx.scene.shape.DrawMode;
import javafx.scene.shape.Line;
import javafx.scene.shape.Sphere;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.stage.StageStyle;
import javafx.util.Duration;
import org.junit.Test;

public class MainFrame extends Application{
    @Override
    public void start(Stage primaryStage){
        GridPane pane = new GridPane();
        pane.setAlignment(Pos.CENTER);   //面板中内容的整体对齐
        pane.setPadding(new Insets(20,20,20,20));
        pane.setHgap(60);
        pane.setVgap(40);
        pane.setStyle(
                "-fx-background-repeat:no-repeat;-fx-background-position:center;-fx-background-radius: 3px;" +
                "-fx-border-color:WHITE;-fx-border-width:3px;-fx-border-radius:3px;");

        Sphere earth = new Sphere(190 );
        earth.setCullFace(CullFace.BACK);
        earth.setDrawMode(DrawMode.FILL);
        Image image2 = new Image("file:C:\\MyRepository\\Java\\Gmax\\src\\main\\java\\userInterface\\timg.jpg");
        PhongMaterial m99 = new PhongMaterial();
        m99.setDiffuseMap(image2);
        earth.setMaterial(m99);

        earth.getTransforms().add(new Rotate(0,Rotate.X_AXIS));
        earth.getTransforms().add(new Rotate(-66.5,Rotate.Y_AXIS));
        earth.getTransforms().add(new Rotate(0,Rotate.Z_AXIS));
        //以下函数用来设定旋转效果
        RotateTransition rt = new RotateTransition();
        rt.setNode(earth);
        rt.setAxis(Rotate.Y_AXIS);
        rt.setCycleCount(RotateTransition.INDEFINITE);
        rt.setDuration(Duration.seconds(999));
        rt.setFromAngle(0);
        rt.setToAngle(99999);
        rt.play();

        ComboBox<String> dataCbo = new ComboBox<>();
        dataCbo.setStyle("-fx-background-color:#DDDDDD;-fx-font-family: Fanwood;" +
                        "-fx-font-size: 25;-fx-background-radius: 15px;");
        dataCbo.setMaxWidth(Double.MAX_VALUE);

        dataCbo.getItems().addAll("Max air temperature","Min air temperature",
                "Max dew temperature","Min dew temperature","Max atmospheric pressure","Min atmospheric pressure","Comprehensive statistics");
        String[] dataStr ={
                "Max air temperature","Min air temperature",
                "Max dew temperature","Min dew temperature",
                "Max atmospheric pressure","Min atmospheric pressure",
                "Comprehensive statistics"
        };

        ComboBox<String> chartCbo = new ComboBox<>();
        chartCbo.setMaxWidth(Double.MAX_VALUE);
        chartCbo.setStyle(
                "-fx-background-color:#DDDDDD;-fx-font-family: Fanwood;" +
                        "-fx-font-size: 25;-fx-background-radius: 15px;");

        dataCbo.setOnMouseClicked(e->{
            chartCbo.getItems().removeAll(chartCbo.getItems());
            Glow glow = new Glow(1);
            dataCbo.setEffect(glow);
        });

        String[] maxAirTemperature = {"line chart","Scatter plot"};
        String[] minAirTemperature = {"line chart","Scatter plot"};
        String[] maxDewTemperature = {"line chart","Scatter plot"};
        String[] minDewTemperature = {"line chart","Scatter plot"};
        String[] maxAtomTemperature = {"line chart","Scatter plot"};
        String[] minAtomTemperature = {"line chart","Scatter plot"};
        String[] comprehensiveStatistics = {"3D scatter plot"};

        Label DataLabel = new Label("Data Source: ");
        DataLabel.setFont(Font.font("Segoe UI Light", 50));

        Label ChartLabel = new Label("Chart type: ");
        ChartLabel.setFont(Font.font("Segoe UI Light", 50));

        Text title = new Text("Meteorological statistics");
        title.setFont(Font.font("Century Gothic",120));
        title.setFill(Color.BLACK);

        DropShadow dropShadow = new DropShadow();
        dropShadow.setColor(Color.GRAY);
        dropShadow.setOffsetX(10.0);
        dropShadow.setOffsetY(10.0);
        dropShadow.setRadius(10.0);
        title.setEffect(dropShadow);

        chartCbo.setOnMouseClicked(e->{
            chartCbo.getItems().removeAll(chartCbo.getItems());
            if(dataCbo.getValue().equals(dataStr[0])) {
                chartCbo.getItems().addAll(maxAirTemperature);
//                System.out.println(cityCbo.getItems());
            }
            else if(dataCbo.getValue().equals(dataStr[1])){
                chartCbo.getItems().addAll(minAirTemperature);
//                System.out.println(cityCbo.getItems());
            }
            else if (dataCbo.getValue().equals(dataStr[2])){
                chartCbo.getItems().addAll(maxDewTemperature);
//                System.out.println(cityCbo.getItems());
            }
            else if(dataCbo.getValue().equals(dataStr[3])) {
//                System.out.println(cityCbo.getItems());
                chartCbo.getItems().addAll(minDewTemperature);
            }
            else if(dataCbo.getValue().equals(dataStr[4])) {
//                System.out.println(cityCbo.getItems());
                chartCbo.getItems().addAll(maxAtomTemperature);
            }
            else if(dataCbo.getValue().equals(dataStr[5])) {
//                System.out.println(cityCbo.getItems());
                chartCbo.getItems().addAll(minAtomTemperature);
            }
            else if(dataCbo.getValue().equals(dataStr[6])) {
//                System.out.println(cityCbo.getItems());
                chartCbo.getItems().addAll(comprehensiveStatistics);
            }
            Glow glow = new Glow(1);
            ChartLabel.setEffect(glow);
        });

        Button graySelect = new Button("     Select     ");
        graySelect.setStyle("-fx-font-size: 25;-fx-background-color:  #DDDDDD;" +
                "-fx-background-radius: 15px;-fx-font-family: 'Hans Kendrick';-fx-text-fill: White;");
        graySelect.setMaxWidth(Double.MAX_VALUE);

        Button blueSelect = new Button("      Let's Rock      ");
        blueSelect.setStyle("-fx-font-size: 25;-fx-background-color:  #2894FF;" +
                "-fx-background-radius: 15px;-fx-font-family: 'Hans Kendrick';-fx-text-fill: White;");
        blueSelect.setMaxWidth(Double.MAX_VALUE);
        blueSelect.setVisible(false);

        pane.add(title,0,0,4,1);
        pane.add(DataLabel,1,1);
        pane.add(dataCbo,2,1,1,1);
        pane.add(ChartLabel,1,2);
        pane.add(chartCbo,2,2,1,1);
        pane.add(blueSelect,2,4,1,1);
        pane.add(graySelect,2,4,1,1);
        pane.add(earth,3,1,1,5);

        FadeTransition comFade0 = new FadeTransition(Duration.millis(3500), dataCbo);
        comFade0.setFromValue(0.0f);
        comFade0.setToValue(1.0f);
        comFade0.setCycleCount(1);

        FadeTransition comFade1 = new FadeTransition(Duration.millis(1000), chartCbo);
        comFade1.setFromValue(0.0f);
        comFade1.setToValue(1.0f);
        comFade1.setCycleCount(1);

        FadeTransition buttFade = new FadeTransition(Duration.millis(1000), graySelect);
        buttFade.setFromValue(0.0f);
        buttFade.setToValue(1.0f);
        buttFade.setCycleCount(1);

        graySelect.setOnMouseEntered(e->{
            FadeTransition fromGrayToBlue = new FadeTransition(Duration.millis(1000), blueSelect);
            blueSelect.setVisible(true);
            fromGrayToBlue.setFromValue(0.0f);
            fromGrayToBlue.setToValue(1.0f);

            FadeTransition fromGrayToBlue1 = new FadeTransition(Duration.millis(1000), graySelect);
            fromGrayToBlue1.setFromValue(1.0f);
            fromGrayToBlue1.setToValue(0.0f);

            ParallelTransition pt0 = new ParallelTransition(fromGrayToBlue,fromGrayToBlue1);
            pt0.play();
        });

        graySelect.setOnMouseExited(e->{
            FadeTransition fromGrayToBlue = new FadeTransition(Duration.millis(1000), graySelect);
            fromGrayToBlue.setFromValue(0.0f);
            fromGrayToBlue.setToValue(1.0f);

            FadeTransition fromGrayToBlue1 = new FadeTransition(Duration.millis(1000), blueSelect);
            fromGrayToBlue1.setFromValue(1.0f);
            fromGrayToBlue1.setToValue(0.0f);
            ParallelTransition pt1 = new ParallelTransition(fromGrayToBlue,fromGrayToBlue1);
            pt1.play();
        });

        graySelect.setOnMouseClicked(e->{
            String dataType = dataCbo.getValue();
            String chartType = chartCbo.getValue();
            Scheduler scheduler = new Scheduler();
            try {
                scheduler.getParameter(dataType,chartType);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        //设置单元格中的对齐方式
        GridPane.setHalignment(graySelect,HPos.LEFT);
        GridPane.setHalignment(blueSelect,HPos.LEFT);
        GridPane.setHalignment(earth,HPos.CENTER);

        pane.setGridLinesVisible(true);
        primaryStage.setWidth(1500);
        primaryStage.setHeight(1000);
        Scene scene = new Scene(pane);
        scene.setFill(Color.TRANSPARENT);// 设置pane的背景色为透明

        primaryStage.setTitle("Designed by 高子龙");
        primaryStage.initStyle(StageStyle.UTILITY); //窗体风格
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}