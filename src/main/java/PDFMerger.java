import org.apache.pdfbox.multipdf.PDFMergerUtility;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public class PDFMerger {

  public void merge(final List<String> paths, final String name) {
    final PDFMergerUtility merger = new PDFMergerUtility();

    for (String s : paths) {
      try {
        merger.addSource(s);
      } catch (FileNotFoundException e) {
        e.printStackTrace();
      }
    }

    merger.setDestinationFileName(name + ".pdf");

    try {
      merger.mergeDocuments(null);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
