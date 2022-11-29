;7 SEGMENTOS PIC16F84A
;Proyecto Números en display 7 segmentos con PIC16F84A
;Credits Youtube:@Social-Master
;Github: @rafopm

include  <P16F84.INC>
org 00h
goto INICIO

REG1	EQU		0CH
REG2	EQU		0DH
REG3	EQU		0EH
CUENTA	EQU		0FH

INICIO call CONFI

CLRF PORTB

CICLO			MOVLW	039H ;B'1101111'
				MOVWF	PORTB
				CALL RETARDO

				MOVLW	06DH ;B'0111111'
				MOVWF	PORTB
				CALL RETARDO
				
				MOVLW	B'0111000'
				MOVWF	PORTB
				CALL RETARDO


				MOVLW	B'1110111'
				MOVWF	PORTB
				CALL RETARDO
				
				MOVLW	006H
				MOVWF	PORTB
				CALL RETARDO

				MOVLW	07DH
				MOVWF	PORTB
				CALL RETARDO

;************************
CONFI	BSF		STATUS, RP0
				 CLRF	TRISB
BCF				STATUS, RP0
				 RETURN
				 
;*************************
RETARDO		MOVLW D'50' ;0DFH
				 MOVWF	REG1
				 
CICLO3			 MOVLW	0A9H
				 MOVWF	REG2
				 
CICLO2			 MOVLW	09H
				 MOVWF	REG3
				 
CICLO1			 DECFSZ	REG3,1
				 GOTO CICLO1
				 
				 DECFSZ	REG2,1
				 GOTO	CICLO2
				 
				 DECFSZ	REG1,1
				 GOTO	CICLO3
				 
				 RETURN
END