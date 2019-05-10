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

    private final Map<Integer, Window> windowCache = new HashMap<>();
    //Cache starts at a really high number
    private final AtomicInteger formIdCache = new AtomicInteger(10000);

    public FormAPI(@NotNull Plugin plugin) {
        plugin.getServer().getPluginManager().registerEvents(new FormDataListener(this), plugin);
    }

    @NotNull
    public Map<Integer, Window> getWindowCache() {
        return this.windowCache;
    }

    @NotNull
    public ModalWindow modalWindow() {
        return new ModalWindow(this, this.formIdCache.getAndIncrement());
    }

    @NotNull
    public ModalWindow modalWindow(@Nullable String formTitle) {
        return new ModalWindow(this, this.formIdCache.getAndIncrement(), formTitle);
    }

    @NotNull
    public ModalWindow modalWindow(@Nullable String formTitle, @Nullable String formContent) {
        return new ModalWindow(this, this.formIdCache.getAndIncrement(), formTitle, formContent);
    }

    @NotNull
    public ModalWindow modalWindow(@Nullable String formTitle, @Nullable String formContent, @Nullable String upperButtonText, @Nullable String lowerButtonText) {
        return new ModalWindow(this, this.formIdCache.getAndIncrement(), formTitle, formContent, upperButtonText, lowerButtonText);
    }

    @NotNull
    public SimpleWindow simpleWindow() {
        return new SimpleWindow(this, this.formIdCache.getAndIncrement());
    }

    @NotNull
    public SimpleWindow simpleWindow(@Nullable String formTitle) {
        return new SimpleWindow(this, this.formIdCache.getAndIncrement(), formTitle);
    }

    @NotNull
    public SimpleWindow simpleWindow(@Nullable String formTitle, @Nullable String formContent) {
        return new SimpleWindow(this, this.formIdCache.getAndIncrement(), formTitle, formContent);
    }

    @NotNull
    public SimpleWindow simpleWindow(@Nullable String formTitle, @Nullable String formContent, @NotNull Map<String, ElementButton> buttons) {
        return new SimpleWindow(this, this.formIdCache.getAndIncrement(), formTitle, formContent, buttons);
    }

    @NotNull
    public CustomWindow customWindow() {
        return new CustomWindow(this, this.formIdCache.getAndIncrement());
    }

    @NotNull
    public CustomWindow customWindow(@Nullable String formTitle) {
        return new CustomWindow(this, this.formIdCache.getAndIncrement(), formTitle);
    }

    @NotNull
    public CustomWindow customWindow(@Nullable String formTitle, @Nullable ElementButton.ImageType formIconType, @Nullable String formIconData) {
        return new CustomWindow(this, this.formIdCache.getAndIncrement(), formTitle, formIconType, formIconData);
    }

    @NotNull
    public CustomWindow customWindow(@Nullable String formTitle, @NotNull List<Element> elements) {
        return new CustomWindow(this, this.formIdCache.getAndIncrement(), formTitle, elements);
    }

    @NotNull
    public CustomWindow customWindow(@Nullable String formTitle, @Nullable ElementButton.ImageType formIconType, @Nullable String formIconData, @NotNull List<Element> elements) {
        return new CustomWindow(this, this.formIdCache.getAndIncrement(), formTitle, formIconType, formIconData, elements);
    }
}
