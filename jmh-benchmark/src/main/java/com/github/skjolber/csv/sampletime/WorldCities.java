package com.github.skjolber.csv.sampletime;

import java.util.concurrent.TimeUnit;

import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.Timeout;
import org.openjdk.jmh.annotations.Warmup;

import com.github.skjolber.csv.AbstractCityCsvParserBenchmark;
import com.github.skjolber.csv.DataFile;

@State(Scope.Benchmark)
public class WorldCities extends AbstractCityCsvParserBenchmark {
	
	public WorldCities() {
		this.dataFile = DataFile.WORLD_CITIES;
	}

}
