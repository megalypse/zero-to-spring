import {MigrationInterface, QueryRunner, Table} from "typeorm";

export class AnimeTable1619811064819 implements MigrationInterface {
    private readonly AnimeTable: Table = new Table({
      name: "animes",
      columns: [
        {
          name: "id",
          type: "int",
          isGenerated: true,
          isUnique: true,
          isPrimary: true,
          isNullable: false
        },
        {
          name: 'name',
          type: 'varchar',
          isNullable: false
        }
      ]
    });

    public async up(queryRunner: QueryRunner): Promise<void> {
      await queryRunner.createTable(this.AnimeTable);
    }

    public async down(queryRunner: QueryRunner): Promise<void> {
      await queryRunner.dropTable(this.AnimeTable);
    }

}
