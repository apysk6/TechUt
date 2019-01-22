Projekt na zaliczenie TechUT.
Temat: Guitar.

Modele:
- Guitar
- Bag
- Producer
- Owner
- Serial

Relacje:
- One-To-One (Guitar - Serial)
- One-To-Many (Guitar - Owner)
- One-To-Many (Owner - Guitar)
- Many-To-One (Guitar - Producer)
- Many-To-Many (Guitar - Bag)

Aby uruchomić przygotowane testy jednostkowe (16), należy uruchomić skrypty z folder "/scripts", a następnie użyć komendy "mvn test".
