import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.util.LinkedList;
import java.util.List;

public class App extends Application {

  @Override
  public void start(Stage stage) throws Exception {
    try {
      FileChooser fileChooser = new FileChooser();
      fileChooser.setTitle("Choose Multiple PDF Files");
      fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("PDF files (*.pdf)", "*.PDF", "*.pdf"));
      List<File> files = fileChooser.showOpenMultipleDialog(stage);

      if (files.size() == 0) {
        Platform.exit();
        System.exit(0);
      }

      List<String> paths = new LinkedList<>();

      for (File f : files) {
        paths.add(f.getAbsolutePath());
      }

      PDFMerger pdfMerger = new PDFMerger();
      pdfMerger.merge(paths, "Merged");

    } catch(Throwable t) {
      Platform.exit();
      System.exit(0);
    }
  }

  public static void main(String[] args){
    launch(args);
  }
}
