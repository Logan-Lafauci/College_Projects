;;;;;;;;;;;;;;;;;;;
;; diskin.csd    ;;
;;;;;;;;;;;;;;;;;;;

<CsoundSynthesizer>

<CsOptions>
-odac
</CsOptions>

<CsInstruments>

;;;;;;;;;;;;;;;;
;; orc header ;;
;;;;;;;;;;;;;;;;

   sr = 44100
   ksmps = 10
   nchnls = 2
   0dbfs = 1

instr 1  ;; soundin instrument
  ;; init score data
  idur     	= p3
  iamp     	= ampdbfs(p4) ;; amplitude in dbfs
  isndfile 	= p5          ;; soundfile name
  iptch			= p6
   
  	ichnls = filenchnls(isndfile) ;; get num channels of soundfile

   ;; instrument definition
   if ichnls == 1 then
      asigL diskin2 isndfile, iptch
      asigR = asigL
   elseif ichnls == 2 then
      asigL, asigR  diskin2 isndfile, iptch
   else
      asigL = 0
      asigR = 0
   endif
   
   kenv   linen iamp, 0.1, idur, 0.1
   
  	asig   = kenv * (asigL+asigR)/2
  	afilt1  butterbp asig, 1000, 800/10
  	afilt2  butterbp afilt1, 1800, 1500/70
	afilt3  butterbp afilt2, 3000, 3000/40	
 	abalance balance2 afilt3, asig
          outs abalance, abalance	
endin

instr 2 ;flooper instrument
   ;; init score data
   idur     = p3
   iamp     = ampdbfs(p4) ;; amplitude in dbfs
   ift      = p5          ;; soundfile name
   itransp  = p6          ;; transposition ratio
   iloop_st = p7
   iloop_end = p8
   ixfade    = p9
   imode     = p10
   
   ;; instrument definition
   kenv   linen iamp, 0.1, idur, 0.1
   asigL, asigR   flooper2 kenv,itransp,iloop_st,iloop_end,ixfade,ift,0,imode

	 asig   = kenv * (asigL+asigR)/2
  	 afilt1  butterbp asig, 1000, 800/10
  	 afilt2  butterbp afilt1, 1800, 1500/70
	 afilt3  butterbp afilt2, 3000, 3000/40	
 	 abalance balance2 afilt3, asig
          outs abalance, abalance	
endin

</CsInstruments>
<CsScore>
;soundfile for flooper?
;f# st len GEN  parans
f 1 0  0   1    "samples/TrpSusMF_C5_LP.aiff" 0 0 0
f 2 0  0   1    "samples/a_BOSEN_mf_A0_st.aiff" 0 0 0

#define HIHAT #"samples/bass.wav"# ;Created my own sample but doesn't sound good with current filters
#define BOUNCE #"samples/bounce.wav"# ;Trial with downloading samples from freesound.org
#define YAM #"samples/Yam_CF3_Cs4.wav"#
#define PIANO #"samples/a_BOSEN_mf_A0_st.aiff"#
#define TRUMPET  #"samples/TrpSusMF_C5_LP.aiff"#

;Accidentally came accross a sound that made me think of horror movies

; #  st  	dur  dbfs  sndfile		pitch	   st		end		fade		mode         
i 2  8		4   	-4    1					0.4			0.3   0.6     0.15    0
i 2  10		2   	-4    1					0.3			0.3   0.6     0.15    0
i 1  16	 	2		-4		$PIANO		1
i 1  +   	2		-4		$PIANO		.8
i 1  +   	2		-4		$PIANO		1
i 1  +   	2		-4		$PIANO		1.2

i 1  0	 	1		-5		$YAM		1
i 1  +   	1		-5		$YAM		1.2
i 1  +   	1		-5		$YAM		1.25
i 1  +   	1		-5		$YAM		1.2125
i 1  +	 	1		-5		$YAM		1
i 1  +   	1		-5		$YAM		1.2
i 1  +   	1		-5		$YAM		1.25
i 1  +   	1		-5		$YAM		1.2125
i 1  +	 	1		-5		$YAM		1
i 1  +   	1		-5		$YAM		1.2
i 1  +   	1		-5		$YAM		1.25
i 1  +   	1		-5		$YAM		1.2125
i 1  +	 	1		-5		$YAM		1
i 1  +   	1		-5		$YAM		1.2
i 1  +   	1		-5		$YAM		1.25
i 1  +   	1		-5		$YAM		1.2125
i 1  +	 	1		-5		$YAM		1
i 1  +   	1		-5		$YAM		1.2
i 1  +   	1		-5		$YAM		1.25
i 1  +   	1		-5		$YAM		1.2125
i 1  +	 	1		-5		$YAM		1
i 1  +   	1		-5		$YAM		1.2
i 1  +   	1		-5		$YAM		1.25
i 1  +   	1		-5		$YAM		1.2125
i 1  +	 	1		-5		$YAM		1
i 1  +   	1		-5		$YAM		1.2
i 1  +   	1		-5		$YAM		1.25
i 1  +   	1		-5		$YAM		1.2125
i 1  +	 	1		-5		$YAM		1
i 1  +   	1		-5		$YAM		1.2
i 1  +   	1		-5		$YAM		1.25
i 1  +   	1		-5		$YAM		1.2125
;i 2  +	 	10		-5		$SNARE ;Can't get to work even in provided week 5 code. 
e








</CsScore>


</CsoundSynthesizer>
<bsbPanel>
 <label>Widgets</label>
 <objectName/>
 <x>100</x>
 <y>100</y>
 <width>320</width>
 <height>240</height>
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
