	.file	"ArrayMax.java.bc"
	.686
	.MMX
	.XMM
	.model flat

	EXTERN printf:near
	EXTERN scanf:near


	.text
	public max
	.align	16
max	proc near
	sub	ESP, 24
.Llabel1:
	mov	EAX, DWORD PTR [ESP + 28]
	mov	DWORD PTR [ESP + 20], EAX
	mov	EAX, DWORD PTR [ESP + 32]
	mov	DWORD PTR [ESP + 16], EAX
	mov	DWORD PTR [ESP + 4], 0
	mov	DWORD PTR [ESP], 4294957296
	jmp	.LBB1_4
	.align	16
.LBB1_1:                                                    # %label_9
                                                            # Loop Depth 1
                                                            # Loop Header is BB1_4
                                                            # Inner Loop
	mov	EAX, DWORD PTR [ESP]
	mov	ECX, DWORD PTR [ESP + 4]
	mov	EDX, DWORD PTR [ESP + 20]
	cmp	DWORD PTR [EDX + 4*ECX], EAX
	jle	.LBB1_3
.LBB1_2:                                                    # %label_13
                                                            # Loop Depth 1
                                                            # Loop Header is BB1_4
                                                            # Inner Loop
	mov	EAX, DWORD PTR [ESP + 4]
	mov	EAX, DWORD PTR [EDX + 4*EAX]
	mov	DWORD PTR [ESP], EAX
.LBB1_3:                                                    # %label_14
                                                            # Loop Depth 1
                                                            # Loop Header is BB1_4
                                                            # Inner Loop
	inc	DWORD PTR [ESP + 4]
.LBB1_4:                                                    # %label_8
                                                            # Loop Depth 1
                                                            # Loop Header
                                                            # Inner Loop
	mov	EAX, DWORD PTR [ESP + 16]
	cmp	DWORD PTR [ESP + 4], EAX
	jl	.LBB1_1
.LBB1_5:                                                    # %label_10
	mov	EAX, DWORD PTR [ESP]
	mov	DWORD PTR [ESP + 8], EAX
	mov	DWORD PTR [ESP + 12], EAX
.LBB1_6:                                                    # %return
	mov	EAX, DWORD PTR [ESP + 12]
	add	ESP, 24
	ret
max	endp


	public main
	.align	16
main	proc near
	push	EDI
.Llabel2:
	push	ESI
.Llabel3:
	sub	ESP, 20
.Llabel4:
	mov	DWORD PTR [ESP], 20
	call	malloc
	mov	DWORD PTR [ESP + 16], 0
	mov	ESI, EAX
	lea	EDI, DWORD PTR [ESP + 12]
	.align	16
.LBB2_1:                                                    # %label_36
                                                            # Loop Depth 1
                                                            # Loop Header
                                                            # Inner Loop
	cmp	DWORD PTR [ESP + 16], 4
	jle	.LBB2_4
.LBB2_2:                                                    # %label_38
	mov	DWORD PTR [ESP], ESI
	mov	DWORD PTR [ESP + 4], 5
	call	max
	mov	DWORD PTR [ESP + 4], EAX
	mov	DWORD PTR [ESP], OFFSET _2E_str2
	call	printf
.LBB2_3:                                                    # %return
	add	ESP, 20
	pop	ESI
	pop	EDI
	ret
.LBB2_4:                                                    # %label_37
                                                            # Loop Depth 1
                                                            # Loop Header is BB2_1
                                                            # Inner Loop
	mov	DWORD PTR [ESP], OFFSET _2E_str0
	call	printf
	mov	DWORD PTR [ESP + 4], EDI
	mov	DWORD PTR [ESP], OFFSET _2E_str1
	call	scanf
	mov	EAX, DWORD PTR [ESP + 12]
	mov	ECX, DWORD PTR [ESP + 16]
	mov	DWORD PTR [ESI + 4*ECX], EAX
	inc	DWORD PTR [ESP + 16]
	jmp	.LBB2_1
main	endp
	.data
_2E_str2:                                                   # .str2
	db 'max:  %d',10,0
_2E_str1:                                                   # .str1
	db '%d',0
	.align	16
_2E_str0:                                                   # .str0
	db 'Enter an integer value: ',0

	.section	.note.GNU-stack,"",@progbits
	end
