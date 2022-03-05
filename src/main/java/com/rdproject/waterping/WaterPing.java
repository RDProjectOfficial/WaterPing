package com.rdproject.waterping;

import com.rdproject.waterping.utils.*;
import net.md_5.bungee.api.plugin.*;

import static com.rdproject.waterping.plugin.LoaderUtil.*;

public class WaterPing extends Plugin {

    @Override
    public void onEnable() {
        ConstantsUtil.plugin = this;
        LoadFeatures();
    }

}