// defining regular expressions for LHC.sc
/*
	check out
	https://gist.github.com/yorgosdiapoulis/8369228
	http://www.regular-expressions.info/quickstart.html
*/
/*
	EXAMPLE
	(
	var word = "BCBCBCCCCCDDCDDDCCCCCCCDCBDCBDCCCDDCCDDCDDBCDDBDDBDBDDCDBDBDCBCDBDCD";
	var pointer = 0;
	var currStr = "";
	var tmp = 0;

	word.do{ | i, k |
	if (word[k].asString == "D") {
	pointer = k;
	currStr = word.copyRange(tmp, pointer);
	//currStr.postln;
	LHCRegExp2(currStr);
	tmp = pointer + 1;
	};
	}
	)
*/
LHCRegExp {

	var regExp;

	*new { | str |
		^super.new.init(str);
	}

	init { | str |
		this.initRegexp;
		this.detectRegExp(str);
	}

	initRegexp {
		regExp = "^D|^B+D|^C+D|^(B+C+)+D|^(C+B+)+D|^(B+C+)+B+D|^(C+B+)+C+D";

	}

	detectRegExp { | str |
		if( regExp.matchRegexp(str, 0, str.size) == true ) {
			str.post; "\t (accepted)".postln;
		}
	}

}