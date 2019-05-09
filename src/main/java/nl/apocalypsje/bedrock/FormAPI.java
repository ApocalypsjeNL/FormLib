package nl.apocalypsje.bedrock;

import cn.nukkit.plugin.Plugin;
import nl.apocalypsje.bedrock.listener.FormDataListener;
import nl.apocalypsje.bedrock.window.ModalWindow;
import nl.apocalypsje.bedrock.window.Window;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.HashMap;
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

    public ModalWindow modalWindow() {
        return new ModalWindow(this, this.formIdCache.getAndIncrement());
    }

    public ModalWindow modalWindow(@Nullable String formTitle) {
        return new ModalWindow(this, this.formIdCache.getAndIncrement(), formTitle);
    }

    public ModalWindow modalWindow(@Nullable String formTitle, @Nullable String formContent) {
        return new ModalWindow(this, this.formIdCache.getAndIncrement(), formTitle, formContent);
    }

    public ModalWindow modalWindow(@Nullable String formTitle, @Nullable String formContent, @Nullable String upperButtonText, @Nullable String lowerButtonText) {
        return new ModalWindow(this, this.formIdCache.getAndIncrement(), formTitle, formContent, upperButtonText, lowerButtonText);
    }
}
