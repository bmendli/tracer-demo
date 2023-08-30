package ru.ok.tracer.demo

import android.app.Application
import ru.ok.tracer.CoreTracerConfiguration
import ru.ok.tracer.HasTracerConfiguration
import ru.ok.tracer.TracerConfiguration
import ru.ok.tracer.crash.report.CrashFreeConfiguration
import ru.ok.tracer.crash.report.CrashReportConfiguration
import ru.ok.tracer.disk.usage.DiskUsageConfiguration
import ru.ok.tracer.heap.dumps.HeapDumpConfiguration
import ru.ok.tracer.profiler.sampling.SamplingProfilerConfiguration
import ru.ok.tracer.profiler.systrace.SystraceProfilerConfiguration

class TracerDemoApp : Application(), HasTracerConfiguration {
    override val tracerConfiguration: List<TracerConfiguration>
        get() = listOf(
            CrashReportConfiguration.build {
                // опции сборщика крэшей
                setEnabled(true)
                setNativeEnabled(true)
                setSendAnr(true)
            },
            CrashFreeConfiguration.build {
                // опции подсчета crash free
                setEnabled(true) // default false
            },
            HeapDumpConfiguration.build {
                // опции сборщика хипдампов при ООМ
                setEnabled(true)
            },
            DiskUsageConfiguration.build {
                // опции анализатора дискового пространства
                setEnabled(true)
                setInterestingSize(3L * 1024 * 1024 * 1024) // 3GB. Default 10GB
                setProbability(1 / 100) // 1%
            },
            SystraceProfilerConfiguration.build {
                // опции systrace-профайлера в продакшене
                setEnabled(true)
            },
            SamplingProfilerConfiguration.build {
                // опции семплирующего профайлера
                setEnabled(true)
            },
        )
}