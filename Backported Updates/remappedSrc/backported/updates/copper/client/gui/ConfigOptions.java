/*
 * Decompiled with CFR 0.152.
 */
package backported.updates.copper.client.gui;

import backported.updates.copper.client.gui.options.Option;
import backported.updates.copper.client.gui.options.OptionGroup;
import backported.updates.copper.client.gui.options.OptionImpl;
import backported.updates.copper.client.gui.options.OptionPage;
import backported.updates.copper.client.gui.options.control.IntegerFieldControl;
import backported.updates.copper.client.gui.options.control.SliderControl;
import backported.updates.copper.client.gui.options.control.TextBoxControl;
import backported.updates.copper.client.gui.options.control.TickBoxControl;
import backported.updates.copper.config.CommonConfig;
import java.util.ArrayList;
import java.util.List;

public class ConfigOptions {
    public static List<OptionPage> createPages() {
        ArrayList<OptionPage> pages = new ArrayList<OptionPage>();
        pages.add(ConfigOptions.createGolemPage());
        pages.add(ConfigOptions.createCompatibilityPage());
        return pages;
    }

    private static OptionPage createGolemPage() {
        Option<Boolean> golemBuildSpawning = OptionImpl.builder(Boolean.class).name("config.copperagebackport.golem_build_spawning").tooltip("config.copperagebackport.golem_build_spawning.tooltip").control(TickBoxControl::new).binding(CommonConfig::golemBuildSpawning, CommonConfig::setGolemBuildSpawning).defaultValue(true).build();
        Option<Boolean> golemPressesButtons = OptionImpl.builder(Boolean.class).name("config.copperagebackport.golem_presses_buttons").tooltip("config.copperagebackport.golem_presses_buttons.tooltip").control(TickBoxControl::new).binding(CommonConfig::golemPressesButtons, CommonConfig::setGolemPressesButtons).defaultValue(true).build();
        Option<Integer> buttonPressChance = OptionImpl.builder(Integer.class).name("config.copperagebackport.button_press_chance").tooltip("config.copperagebackport.button_press_chance.tooltip").control(opt -> new SliderControl((Option<Integer>)opt, 0, 100, 5, "%")).binding(CommonConfig::buttonPressChancePercent, CommonConfig::setButtonPressChancePercent).defaultValue(10).available(CommonConfig::golemPressesButtons).build();
        Option<Integer> golemTransportStackSize = OptionImpl.builder(Integer.class).name("config.copperagebackport.golem_transport_stack_size").tooltip("config.copperagebackport.golem_transport_stack_size.tooltip").control(opt -> new SliderControl((Option<Integer>)opt, 1, 64, 1, "")).binding(CommonConfig::golemTransportStackSize, CommonConfig::setGolemTransportStackSize).defaultValue(16).build();
        Option<Integer> weatheringTickFrom = OptionImpl.builder(Integer.class).name("config.copperagebackport.weathering_tick_from").tooltip("config.copperagebackport.weathering_tick_from.tooltip").control(opt -> new IntegerFieldControl((Option<Integer>)opt, 0, 10000000, IntegerFieldControl.ValueFormatter.realMinutes())).binding(CommonConfig::weatheringTickFrom, CommonConfig::setWeatheringTickFrom).defaultValue(504000).build();
        Option<Integer> weatheringTickTo = OptionImpl.builder(Integer.class).name("config.copperagebackport.weathering_tick_to").tooltip("config.copperagebackport.weathering_tick_to.tooltip").control(opt -> new IntegerFieldControl((Option<Integer>)opt, weatheringTickFrom::getValue, 10000000, IntegerFieldControl.ValueFormatter.realMinutes())).binding(CommonConfig::weatheringTickTo, CommonConfig::setWeatheringTickTo).defaultValue(552000).build();
        OptionGroup transportGroup = OptionGroup.builder().name("config.copperagebackport.group.transport").add(golemTransportStackSize).build();
        OptionGroup behaviorGroup = OptionGroup.builder().name("config.copperagebackport.group.behavior").add(golemBuildSpawning).add(golemPressesButtons).add(buttonPressChance).build();
        OptionGroup weatheringGroup = OptionGroup.builder().name("config.copperagebackport.group.weathering").add(weatheringTickFrom).add(weatheringTickTo).build();
        return OptionPage.builder().name("config.copperagebackport.page.golem").add(transportGroup).add(behaviorGroup).add(weatheringGroup).build();
    }

    private static OptionPage createCompatibilityPage() {
        Option<String> lightningRodInfo = OptionImpl.builder(String.class).name("config.copperagebackport.lightning_rod_oxidation").control(TextBoxControl::new).binding(() -> "config.copperagebackport.lightning_rod_oxidation.text", v -> {}).defaultValue("config.copperagebackport.lightning_rod_oxidation.text").build();
        OptionGroup lightningRodGroup = OptionGroup.builder().name("config.copperagebackport.group.lightning_rod").add(lightningRodInfo).build();
        return OptionPage.builder().name("config.copperagebackport.page.compatibility").add(lightningRodGroup).build();
    }
}

