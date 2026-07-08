/*
 * Decompiled with CFR 0.152.
 */
package backported.updates.foundation.core.fabric;

import backported.updates.foundation.core.Environment;
import backported.updates.foundation.core.ModInstance;
import backported.updates.foundation.core.ParallelDispatch;
import backported.updates.foundation.core.fabric.FabricParallelDispatch;
import java.util.function.Consumer;

public class ModInstanceBuilderImpl {
    public static ModInstance builder(String modId, Runnable common, Consumer<ParallelDispatch> postCommon, Runnable client, Consumer<ParallelDispatch> postClient) {
        return new ModInstance(modId, common, (Consumer)postCommon, client, (Consumer)postClient){

            @Override
            public void bootstrap() {
                FabricParallelDispatch dispatch = new FabricParallelDispatch();
                this.onCommon.run();
                this.onPostCommon.accept(dispatch);
                if (Environment.isClientSide()) {
                    this.onClient.run();
                    this.onPostClient.accept(dispatch);
                }
            }
        };
    }
}

