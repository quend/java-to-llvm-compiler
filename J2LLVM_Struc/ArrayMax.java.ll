		; ModuleID = 'ArrayMax.java.ll'

target datalayout = "e-p:32:32:32-i1:8:8-i8:8:8-i16:16:16-i32:32:32-i64:32:64-f32:32:32-f64:32:64-v64:64:64-v128:128:128-a0:0:64-s0:0:64-f80:32:32"
target triple = "i686-pc-linux-gnu"

		; Global values
@.str2 = internal constant [10 x i8]  c"max:  %d
\00"
@.str1 = internal constant [3 x i8]  c"%d\00"
@.str0 = internal constant [25 x i8]  c"Enter an integer value: \00"

		; External declarations
declare i32 @printf(i8*, ...)
declare i32 @scanf(i8*, ...)

		; method_header
define i32 @max(i32* %a, i32 %n) {
entry:
	%a_addr = alloca i32*
	store i32* %a, i32** %a_addr
	%n_addr = alloca i32
	store i32 %n, i32* %n_addr
	%retval = alloca i32
	%tmp = alloca i32
		; M3
	%i = alloca i32
	%max = alloca i32
		; assignment
	store i32 0, i32* %i
		; unary_minus_expression
	%tmp0 = sub i32 0, 10000
		; assignment
	store i32 %tmp0, i32* %max
	br label %label_8
label_8:	; l_Begin
		; relational_LT_expression
	%tmp1 = load i32* %i
	%tmp2 = load i32* %n_addr
	%tmp3 = icmp slt i32 %tmp1, %tmp2
	br i1 %tmp3, label %label_9, label %label_10
label_9:	; l_True
		; array_access
	%tmp4 = load i32** %a_addr
	%tmp5 = load i32* %i
	%tmp6 = getelementptr i32* %tmp4, i32 %tmp5
		; relational_GT_expression
	%tmp7 = load i32* %tmp6
	%tmp8 = load i32* %max
	%tmp9 = icmp sgt i32 %tmp7, %tmp8
	br i1 %tmp9, label %label_13, label %label_14
label_13:	; l_True
		; array_access
	%tmp10 = load i32* %i
	%tmp11 = getelementptr i32* %tmp4, i32 %tmp10
		; assignment
	%tmp12 = load i32* %tmp11
	store i32 %tmp12, i32* %max
	br label %label_14
label_14:	; l_False
		; additive_PLUS_expression
	%tmp13 = load i32* %i
	%tmp14 = add i32 %tmp13, 1
		; assignment
	store i32 %tmp14, i32* %i
	br label %label_8
label_10:	; l_False
		; return_statement
	%tmp15 = load i32* %max
	store i32 %tmp15, i32* %tmp
	%tmp16 = load i32* %tmp
	store i32 %tmp16, i32* %retval
	br label %return
		; method_declaration_end
	br label %return
return:
	%tmp17 = load i32* %retval
	ret i32 %tmp17
}

		; method_header
define void @main() {
entry:
		; M3
	%i = alloca i32
	%n = alloca i32
		; array_creation
	%tmp18 = malloc [5 x i32]
		; assignment
	store i32 0, i32* %i
	br label %label_36
label_36:	; l_Begin
		; relational_LT_expression
	%tmp19 = load i32* %i
	%tmp20 = icmp slt i32 %tmp19, 5
	br i1 %tmp20, label %label_37, label %label_38
label_37:	; l_True
		; method_invocation
	%tmp21 = call i32 (i8*, ...)* @printf(i8* getelementptr ([25 x i8]* @.str0, i32 0, i32 0) )
		; method_invocation
	%tmp22 = call i32 (i8*, ...)* @scanf(i8* getelementptr ([3 x i8]* @.str1, i32 0, i32 0) , i32* %n)
		; array_access
	%tmp23 = load i32* %i
	%tmp24 = getelementptr [5 x i32]* %tmp18, i32 0, i32 %tmp23
		; assignment
	%tmp25 = load i32* %n
	store i32 %tmp25, i32* %tmp24
		; additive_PLUS_expression
	%tmp26 = load i32* %i
	%tmp27 = add i32 %tmp26, 1
		; assignment
	store i32 %tmp27, i32* %i
	br label %label_36
label_38:	; l_False
		; method_invocation
	%tmp28 = bitcast [5 x i32]* %tmp18 to i32*
	%tmp29 = call i32 @max(i32* %tmp28, i32 5)
		; method_invocation
	%tmp30 = call i32 (i8*, ...)* @printf(i8* getelementptr ([10 x i8]* @.str2, i32 0, i32 0) , i32 %tmp29)
		; method_declaration_end
	br label %return
return:
	ret void
}


