package Components;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.switchTo;

public class FrameComponents {
    public void closeFrame() {

        switchTo().frame("fl-403933");
        $(".js-widget").$("button.close").click();
        switchTo().defaultContent();

    }
}
