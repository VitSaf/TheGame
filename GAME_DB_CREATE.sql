CREATE TABLE "games" (
	"game_id" serial NOT NULL,
	"player1_nickname" varchar(50) NOT NULL,
	"player2_nickname" varchar(50) NOT NULL,
	"player1_hero" varchar(15) NOT NULL,
	"player2_hero" varchar(15) NOT NULL,
	CONSTRAINT "games_pk" PRIMARY KEY ("game_id")
) WITH (
  OIDS=FALSE
);



CREATE TABLE "moves" (
	"move_id" serial NOT NULL,
	"game_id" int NOT NULL,
	"move_num" int NOT NULL,
	"player1_move" varchar(20) NOT NULL,
	"player2_move" varchar(20) NOT NULL,
	CONSTRAINT "moves_pk" PRIMARY KEY ("move_id")
) WITH (
  OIDS=FALSE
);




ALTER TABLE "moves" ADD CONSTRAINT "moves_fk0" FOREIGN KEY ("game_id") REFERENCES "games"("game_id");

