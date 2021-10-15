;;;;;;;;;;;;;;;;;;;
;; filename.csd ;;
;;;;;;;;;;;;;;;;;;;

<CsoundSynthesizer>

<CsOptions>
-odac
</CsOptions>

<CsInstruments>

;;;;;;;;;;;;;;;;
;; orc header ;;
;;;;;;;;;;;;;;;;

	sr 		= 44100
	ksmps 	= 32
	nchnls	= 2
	
	0dbfs	= 1.0

instr 1	;;;HW2 filter 1 comb filter

	;; init time
	idur		= p3
	iamp		= ampdbfs(p4)
	icps		= cpspch(p5)
	ift		=	p6
	
	;; envelope params
	iatt_mult[] fillarray		0, 0.1, 0.2, 0.3, 0.4, 0.5, 0.6, 0.7, 0.8, 0.9, 1
	idecay_mult[] fillarray	0, 0.1, 0.2, 0.3, 0.4, 0.5, 0.6, 0.7, 0.8, 0.9, 1
		
	kenv1	linen 	iamp, iatt_mult[2]*idur, idur, idecay_mult[8]*idur
	kenv2	linen 	iamp, iatt_mult[2]*idur, idur, idecay_mult[8]*idur
	kenv3	linen 	iamp, iatt_mult[3]*idur, idur, idecay_mult[7]*idur
	kenv4	linen 	iamp, iatt_mult[3]*idur, idur, idecay_mult[7]*idur
	kenv5	linen 	iamp, iatt_mult[4]*idur, idur, idecay_mult[6]*idur
	kenv6	linen 	iamp, iatt_mult[4]*idur, idur, idecay_mult[6]*idur
	kenv7	linen 	iamp, iatt_mult[5]*idur, idur, idecay_mult[5]*idur
	kenv8	linen 	iamp, iatt_mult[5]*idur, idur, idecay_mult[5]*idur
	kenv9	linen 	iamp, iatt_mult[6]*idur, idur, idecay_mult[4]*idur
	kenv10	linen 	iamp, iatt_mult[6]*idur, idur, idecay_mult[4]*idur
	
	asig1	oscil 	kenv1, icps*1, ift
	asig2	oscil 	kenv2, icps*2, ift
	asig3	oscil 	kenv3, icps*1, ift
	asig4	oscil 	kenv4, icps*3, ift
	asig5	oscil 	kenv5, icps*1, ift
	asig6	oscil 	kenv6, icps*3, ift
	asig7	oscil 	kenv7, icps*1, ift
	asig8	oscil 	kenv8, icps*2, ift
	asig9	oscil 	kenv9, icps*1, ift
	asig10	oscil 	kenv10, icps*2, ift
	
	kenv		linen	1, iatt_mult[2]*idur, idur, idecay_mult[8]*idur
	aout		= kenv*(asig1 + asig2 + asig3 + asig4 + asig5 + asig6 + asig7 + asig8 + asig9 + asig10)/10
	afilter comb aout, 5, .01
	
	outs		afilter,afilter
	
endin

instr 2	;;;HW2 filter 2 High pass

	;; init time
	idur		= p3
	iamp		= ampdbfs(p4)
	icps		= cpspch(p5)
	ift		=	p6
	
	;; envelope params
	iatt_mult[] fillarray		0, 0.1, 0.2, 0.3, 0.4, 0.5, 0.6, 0.7, 0.8, 0.9, 1
	idecay_mult[] fillarray	0, 0.1, 0.2, 0.3, 0.4, 0.5, 0.6, 0.7, 0.8, 0.9, 1
		
	kenv1	linen 	iamp, iatt_mult[2]*idur, idur, idecay_mult[8]*idur
	kenv2	linen 	iamp, iatt_mult[2]*idur, idur, idecay_mult[8]*idur
	kenv3	linen 	iamp, iatt_mult[3]*idur, idur, idecay_mult[7]*idur
	kenv4	linen 	iamp, iatt_mult[3]*idur, idur, idecay_mult[7]*idur
	kenv5	linen 	iamp, iatt_mult[4]*idur, idur, idecay_mult[6]*idur
	kenv6	linen 	iamp, iatt_mult[4]*idur, idur, idecay_mult[6]*idur
	kenv7	linen 	iamp, iatt_mult[5]*idur, idur, idecay_mult[5]*idur
	kenv8	linen 	iamp, iatt_mult[5]*idur, idur, idecay_mult[5]*idur
	kenv9	linen 	iamp, iatt_mult[6]*idur, idur, idecay_mult[4]*idur
	kenv10	linen 	iamp, iatt_mult[6]*idur, idur, idecay_mult[4]*idur
	
	asig1	oscil 	kenv1, icps*1, ift
	asig2	oscil 	kenv2, icps*2, ift
	asig3	oscil 	kenv3, icps*1, ift
	asig4	oscil 	kenv4, icps*3, ift
	asig5	oscil 	kenv5, icps*1, ift
	asig6	oscil 	kenv6, icps*3, ift
	asig7	oscil 	kenv7, icps*1, ift
	asig8	oscil 	kenv8, icps*2, ift
	asig9	oscil 	kenv9, icps*1, ift
	asig10	oscil 	kenv10, icps*2, ift
	
	kenv		linen	1, iatt_mult[2]*idur, idur, idecay_mult[8]*idur
	aout		= kenv*(asig1 + asig2 + asig3 + asig4 + asig5 + asig6 + asig7 + asig8 + asig9 + asig10)/10
	afilter atone aout, 900
	
	outs		afilter, afilter
	
endin

instr 3	;;;HW2 filter 3 Low pass

	;; init time
	idur		= p3
	iamp		= ampdbfs(p4)
	icps		= cpspch(p5)
	ift		=	p6
	
	;; envelope params
	iatt_mult[] fillarray		0, 0.1, 0.2, 0.3, 0.4, 0.5, 0.6, 0.7, 0.8, 0.9, 1
	idecay_mult[] fillarray	0, 0.1, 0.2, 0.3, 0.4, 0.5, 0.6, 0.7, 0.8, 0.9, 1
		
	kenv1	linen 	iamp, iatt_mult[2]*idur, idur, idecay_mult[8]*idur
	kenv2	linen 	iamp, iatt_mult[2]*idur, idur, idecay_mult[8]*idur
	kenv3	linen 	iamp, iatt_mult[3]*idur, idur, idecay_mult[7]*idur
	kenv4	linen 	iamp, iatt_mult[3]*idur, idur, idecay_mult[7]*idur
	kenv5	linen 	iamp, iatt_mult[4]*idur, idur, idecay_mult[6]*idur
	kenv6	linen 	iamp, iatt_mult[4]*idur, idur, idecay_mult[6]*idur
	kenv7	linen 	iamp, iatt_mult[5]*idur, idur, idecay_mult[5]*idur
	kenv8	linen 	iamp, iatt_mult[5]*idur, idur, idecay_mult[5]*idur
	kenv9	linen 	iamp, iatt_mult[6]*idur, idur, idecay_mult[4]*idur
	kenv10	linen 	iamp, iatt_mult[6]*idur, idur, idecay_mult[4]*idur
	
	asig1	oscil 	kenv1, icps*1, ift
	asig2	oscil 	kenv2, icps*2, ift
	asig3	oscil 	kenv3, icps*1, ift
	asig4	oscil 	kenv4, icps*3, ift
	asig5	oscil 	kenv5, icps*1, ift
	asig6	oscil 	kenv6, icps*3, ift
	asig7	oscil 	kenv7, icps*1, ift
	asig8	oscil 	kenv8, icps*2, ift
	asig9	oscil 	kenv9, icps*1, ift
	asig10	oscil 	kenv10, icps*2, ift
	
	kenv		linen	1, iatt_mult[2]*idur, idur, idecay_mult[8]*idur
	aout		= kenv*(asig1 + asig2 + asig3 + asig4 + asig5 + asig6 + asig7 + asig8 + asig9 + asig10)/10
	afilter tone aout, 300
	
	outs		afilter,afilter
	
endin

instr 4;;;HW2 filter 4 no filter used to test difference 

	;; init time
	idur		= p3
	iamp		= ampdbfs(p4)
	icps		= cpspch(p5)
	ift		=	p6
	
	;; envelope params
	iatt_mult[] fillarray		0, 0.1, 0.2, 0.3, 0.4, 0.5, 0.6, 0.7, 0.8, 0.9, 1
	idecay_mult[] fillarray	0, 0.1, 0.2, 0.3, 0.4, 0.5, 0.6, 0.7, 0.8, 0.9, 1
		
	kenv1	linen 	iamp, iatt_mult[2]*idur, idur, idecay_mult[8]*idur
	kenv2	linen 	iamp, iatt_mult[2]*idur, idur, idecay_mult[8]*idur
	kenv3	linen 	iamp, iatt_mult[3]*idur, idur, idecay_mult[7]*idur
	kenv4	linen 	iamp, iatt_mult[3]*idur, idur, idecay_mult[7]*idur
	kenv5	linen 	iamp, iatt_mult[4]*idur, idur, idecay_mult[6]*idur
	kenv6	linen 	iamp, iatt_mult[4]*idur, idur, idecay_mult[6]*idur
	kenv7	linen 	iamp, iatt_mult[5]*idur, idur, idecay_mult[5]*idur
	kenv8	linen 	iamp, iatt_mult[5]*idur, idur, idecay_mult[5]*idur
	kenv9	linen 	iamp, iatt_mult[6]*idur, idur, idecay_mult[4]*idur
	kenv10	linen 	iamp, iatt_mult[6]*idur, idur, idecay_mult[4]*idur
	
	asig1	oscil 	kenv1, icps*1, ift
	asig2	oscil 	kenv2, icps*2, ift
	asig3	oscil 	kenv3, icps*1, ift
	asig4	oscil 	kenv4, icps*3, ift
	asig5	oscil 	kenv5, icps*1, ift
	asig6	oscil 	kenv6, icps*3, ift
	asig7	oscil 	kenv7, icps*1, ift
	asig8	oscil 	kenv8, icps*2, ift
	asig9	oscil 	kenv9, icps*1, ift
	asig10	oscil 	kenv10, icps*2, ift
	
	kenv		linen	1, iatt_mult[2]*idur, idur, idecay_mult[8]*idur
	aout		= kenv*(asig1 + asig2 + asig3 + asig4 + asig5 + asig6 + asig7 + asig8 + asig9 + asig10)/10
	
	outs		aout,aout
	
endin

</CsInstruments>
<CsScore>
;; fxn tables
;;# 	st 	size		GEN	params
f1		0		8192		9		1 1 0 ;; sine wave
f2		0		8192		9		1 1 0	2 0.5 0	3 0.25 0		4 0.125 0	5 0.0625 0 ;; ramp wave
f3		0		8192		9		1 1 0	3 0.5 0 	5 0.25 0		7 0.125 0 ;; quasi-square
f4 	0 		8192 	10 	1 									 ;; sine wave
f5 	0 		8192 	10 	1 .5 .25 .125 .0625  ;; ramp wave
f6 	0 		8192 	10 	1 0 .5 0 .25 0 .125  ;; quasi-square
f7 	0 		8192 	11 	1 				;; sine wave
f8 	0 		8192 	11 	10 1 0.5 ;; ramp wave
f9 	0 		8192 	11 	10 1 1 	;; buzz
f10 0 8192 10 1 0.5 0.25 0.125 0.0625 0.03125 ;; sawtooth wave


;; notes
;;#	st		dur	dbfs		pch		ft	
i1		0		30		-7			6.00		5
i3		1		.5		-1			7.00		1
i3		+		.25	-1			8.00		1
i3		+		.5		-1 		8.10		1
i3		+		.25	-1 		7.00		1
i3		+		.5		-1 		6.20		1
i3		+		.25	-1			7.10		1
i3		+		.25	-1 		7.00		1
i3		+		.25	-1 		6.10		1
i3		+		.25	-1 		6.00		1
;;repeat 4sec
i3		+		.5		-1			7.00		1
i3		+		.25	-1			8.00		1
i3		+		.5		-1 		8.10		1
i3		+		.25	-1 		7.00		1
i3		+		.5		-1 		6.20		1
i3		+		.25	-1			7.10		1
i3		+		.25	-1 		7.00		1
i3		+		.25	-1 		6.10		1
i3		+		.25	-1 		6.00		1
;;repeat 7sec
i3		+		.5		-1			7.00		1
i3		+		.25	-1			8.00		1
i3		+		.5		-1 		8.10		1
i3		+		.25	-1 		7.00		1
i3		+		.5		-1 		6.20		1
i3		+		.25	-1			7.10		1
i3		+		.25	-1 		7.00		1
i3		+		.25	-1 		6.10		1
i3		+		.25	-1 		6.00		1
;;repeat 10sec
i3		+		.5		-2			7.00		1
i3		+		.25	-2			8.00		1
i3		+		.5		-2 		8.10		1
i3		+		.25	-2 		7.00		1
i3		+		.5		-2 		6.20		1
i3		+		.25	-2			7.10		1
i3		+		.25	-2 		7.00		1
i3		+		.25	-2 		6.10		1
i3		+		.25	-2 		6.00		1
;;repeat 13sec
i3		+		.5		-2			7.00		1
i3		+		.25	-2			8.00		1
i3		+		.5		-2 		8.10		1
i3		+		.25	-2 		7.00		1
i3		+		.5		-2 		6.20		1
i3		+		.25	-2			7.10		1
i3		+		.25	-2 		7.00		1
i3		+		.25	-2 		6.10		1
i3		+		.25	-2 		6.00		1
;;repeat 16sec
i3		+		.5		-2			7.00		1
i3		+		.25	-2			8.00		1
i3		+		.5		-2 		8.10		1
i3		+		.25	-2 		7.00		1
i3		+		.5		-2 		6.20		1
i3		+		.25	-2			7.10		1
i3		+		.25	-2 		7.00		1
i3		+		.25	-2 		6.10		1
i3		+		.25	-2 		6.00		1
;;repeat 19sec
i3		+		.5		-2			7.00		1
i3		+		.25	-2			8.00		1
i3		+		.5		-2 		8.10		1
i3		+		.25	-2 		7.00		1
i3		+		.5		-2 		6.20		1
i3		+		.25	-2			7.10		1
i3		+		.25	-2 		7.00		1
i3		+		.25	-2 		6.10		1
i3		+		.25	-2 		6.00		1
;;repeat 22sec
i3		+		.5		-2			7.00		1
i3		+		.25	-2			8.00		1
i3		+		.5		-2 		8.10		1
i3		+		.25	-2 		7.00		1
i3		+		.5		-2 		6.20		1
i3		+		.25	-2			7.10		1
i3		+		.25	-2 		7.00		1
i3		+		.25	-2 		6.10		1
i3		+		.25	-2 		6.00		1
;;repeat 25sec
i3		+		.5		-2			7.00		1
i3		+		.25	-2			8.00		1
i3		+		.5		-2 		8.10		1
i3		+		.25	-2 		7.00		1
i3		+		.5		-2 		6.20		1
i3		+		.25	-2			7.10		1
i3		+		.25	-2 		7.00		1
i3		+		.25	-2 		6.10		1
i3		+		.25	-2 		6.00		1
;;repeat 28sec and ending
i3		+		.5		-3			7.00		1
i3		+		.25	-4			8.00		1
i3		+		.5		-5 		8.10		1
i3		+		.25	-6 		7.00		1
i3		+		.5		-7 		6.20		1
i3		+		.25	-8			7.10		1
i3		+		.25	-9 		7.00		1
i3		+		.25	-10 		6.10		1
i3		+		.25	-11		6.00		1
i3		+		.5		-12		7.00		1
i3		+		.25	-13		8.00		1
i3		+		.5		-14		8.10		1
i3		+		.25	-15		7.00		1
i3		+		.5		-16		6.20		1
i3		+		.25	-17		7.10		1
i3		+		.25	-18 		7.00		1
i3		+		.25	-19 		6.10		1
i3		+		.25	-20 		6.00		1
;;#	st		dur	dbfs		pch		ft		fc		Q
i2		10		3		-1 		6.20		10	
i2		13		3		-1 		7.10		10
i2		16		3		-1 		8.00		10	
i2		19		3		-1			7.10		10		
i2		22		3		-1			6.20		10		
i2		25		3		-1			6.10		10		
e

</CsScore>
</CsoundSynthesizer>
<bsbPanel>
 <label>Widgets</label>
 <objectName/>
 <x>322</x>
 <y>472</y>
 <width>905</width>
 <height>507</height>
 <visible>true</visible>
 <uuid/>
 <bgcolor mode="nobackground">
  <r>255</r>
  <g>255</g>
  <b>255</b>
 </bgcolor>
</bsbPanel>
<bsbPresets>
</bsbPresets>
