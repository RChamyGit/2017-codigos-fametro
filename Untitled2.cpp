#include <stdio.h>
#include <stdlib.h>

int main(){
	int x,y;
	
	printf("leia x");
	scanf("%d",&x);
	
	printf("\nleia y: ");
	scanf("%d",&y);
	
	printf("%d",soma(x+y));

	system("pause");
}
