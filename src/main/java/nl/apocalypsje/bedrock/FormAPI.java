package nl.apocalypsje.bedrock;

import cn.nukkit.plugin.Plugin;
import nl.apocalypsje.bedrock.element.Element;
import nl.apocalypsje.bedrock.element.ElementButton;
import nl.apocalypsje.bedrock.listener.FormDataListener;
import nl.apocalypsje.bedrock.window.CustomWindow;
import nl.apocalypsje.bedrock.window.ModalWindow;
import nl.apocalypsje.bedrock.window.SimpleWindow;
import nl.apocalypsje.bedrock.window.Window;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class FormAPI {

    private static final Map<Integer, Window> windowCache = new HashMap<>();
    //Cache starts at a really high number
    private static final AtomicInteger formIdCache = new AtomicInteger(10000);

    public static void initialize(@NotNull Plugin plugin) {
        plugin.getServer().getPluginManager().registerEvents(new FormDataListener(), plugin);
    }

    @NotNull
    public static Map<Integer, Window> getWindowCache() {
        return windowCache;
    }

    @NotNull
    public static ModalWindow modalWindow() {
        return new ModalWindow(formIdCache.getAndIncrement());
    }

    @NotNull
    public static ModalWindow modalWindow(@Nullable String formTitle) {
        return new ModalWindow(formIdCache.getAndIncrement(), formTitle);
    }

    @NotNull
    public static ModalWindow modalWindow(@Nullable String formTitle, @Nullable String formContent) {
        return new ModalWindow(formIdCache.getAndIncrement(), formTitle, formContent);
    }

    @NotNull
    public static ModalWindow modalWindow(@Nullable String formTitle, @Nullable String formContent, @Nullable String upperButtonText, @Nullable String lowerButtonText) {
        return new ModalWindow(formIdCache.getAndIncrement(), formTitle, formContent, upperButtonText, lowerButtonText);
    }

    @NotNull
    public static SimpleWindow simpleWindow() {
        return new SimpleWindow(formIdCache.getAndIncrement());
    }

    @NotNull
    public static SimpleWindow simpleWindow(@Nullable String formTitle) {
        return new SimpleWindow(formIdCache.getAndIncrement(), formTitle);
    }

    @NotNull
    public static SimpleWindow simpleWindow(@Nullable String formTitle, @Nullable String formContent) {
        return new SimpleWindow(formIdCache.getAndIncrement(), formTitle, formContent);
    }

    @NotNull
    public static SimpleWindow simpleWindow(@Nullable String formTitle, @Nullable String formContent, @NotNull Map<String, ElementButton> buttons) {
        return new SimpleWindow(formIdCache.getAndIncrement(), formTitle, formContent, buttons);
    }

    @NotNull
    public static CustomWindow customWindow() {
        return new CustomWindow(formIdCache.getAndIncrement());
    }

    @NotNull
    public static CustomWindow customWindow(@Nullable String formTitle) {
        return new CustomWindow(formIdCache.getAndIncrement(), formTitle);
    }

    @NotNull
    public static CustomWindow customWindow(@Nullable String formTitle, @Nullable ElementButton.ImageType formIconType, @Nullable String formIconData) {
        return new CustomWindow(formIdCache.getAndIncrement(), formTitle, formIconType, formIconData);
    }

    @NotNull
    public static CustomWindow customWindow(@Nullable String formTitle, @NotNull List<Element> elements) {
        return new CustomWindow(formIdCache.getAndIncrement(), formTitle, elements);
    }

    @NotNull
    public static CustomWindow customWindow(@Nullable String formTitle, @Nullable ElementButton.ImageType formIconType, @Nullable String formIconData, @NotNull List<Element> elements) {
        return new CustomWindow(formIdCache.getAndIncrement(), formTitle, formIconType, formIconData, elements);
    }
}
