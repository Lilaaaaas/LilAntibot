package me.kr1s_d.ultimateantibot.common.objects.interfaces;

public interface ICore {
    void load();

    void addNewThread(Runnable runnable, long millis);
}
