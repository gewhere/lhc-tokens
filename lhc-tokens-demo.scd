// s.options.inDevice = ServerOptions.devices[5];
// s.options.outDevice = ServerOptions.devices[5];
s.boot;

SynthDef(\click, { Out.ar(0, FreeVerb.ar(Pan2.ar(RHPF.ar(PinkNoise.ar(1) * EnvGen.ar(Env.perc(0.01, 0.025), doneAction:2), 5000, 0.5, mul: 0.35)))) }).add;


(
a = LHC((
	symbol: { | self, symbol |
		self.soundOn.postln;
		if (self.soundOn) {
			(degree: (A: 11, B: 12, C: 13, D: 14)[symbol]).play
		}
	},
	counter: { | self, counter |
		if (counter > 0) {
			(degree: counter).play;
			self.soundOn = true;
			self.soundOn.postln;
		}{
			self.soundOn = false
		}
	}
)).start;
a.waitTime = 0.65;
)