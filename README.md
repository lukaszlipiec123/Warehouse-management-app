
Projekt zrealizowany jako aplikacja do zarządzani magazynami na potrzeby studiów w PJATK (Przedmiot GUI).

Program został wykonany według wymagań projektu w języku Java.
Założenia projektowe są zrealizowane według następujących implementacji.

Utworzony jest podział na klasy wyszczególnione w założeniach projektu:
Room, Magazine, Vehicle, Bike, Car, Item, Motorcycle, Person wraz z wyjątkiami NeverRentException i TooManyThingsException. Klasa Main posiada główną metodę uruchomieniową i odpowiada za interakcje klas projektu z użytkownikiem.

Klasa Vehicle jest klasą bazową dla jej klas pochodnych - Bike, Car i Motorcycle. Zawiera metody wspólne dla klas pochodnych, zostawiając rzeczy specyficzne dla klas do zaimplementowania we własnych zakresie.

Klasy Vehicle, Car i Bike zawierają wyspecjalizowane konstruktory, zawierające unikalne pola wyszczególnione w wymaganiach projektu.

Klasa Item reprezentuje przedmiot. Implementacja obejmuje wymagania z dokumentacji. Klasa implementuje stan spakowania za pomocą zmiennej "isPacked", która jest tworzona losowo w momencie tworzenia instancji klasy oraz ma bezpośredni wpływ na zajmowaną przez nią powierzchnię.

Klasa Person reprezentuje osobę. Posiada dane wymienione w dokumentacji - imię, nazwisko etc. wraz z metodami dostępu do tych danych. Na chwilę obecną osoba nie wynajmująca pomieszczenia może umieścić w nim przedmiot.

Klasa Magazine reprezentuje magazyn. Zawiera metodę zapisującą stan magazynu do pliku oraz metodę sortującą stan pomieszczenia przed zapisem.

Klasa Room reprezentuje pomieszczenie. Rzeczy przechowywane w pomieszczeniu dzielą się na przedmioty oraz pochodne klasy Vehicle - stąd 2 osobne listy.
Dodatkowo klasa odpowiada za umieszczanie i wyjmowanie rzeczy z pomieszczenia, z zachowaniem założeń takich jak np. zablokowanie dodania rzeczy, na którą nie ma miejsca w pomieszczeniu. Klasa reprezentuje stan wyłączenia z użytku za pomocą zmiennej klasowej "isReady" oraz metody do jej obsługi. Reszta szczegółów implementacyjnych jest zgodna z zaleceniami projektu.

Klasy wyjątków TooManyThingsException i NeverRentException odpowiadają za szczególne przypadki - odpowiednio próbę umieszczenia zbyt dużej ilości rzeczy w pomieszczeniu oraz próbę pobrania daty pierwszego wynajmu od osoby, która nie wykonałą nigdy wynajmu pomieszczenia.

Klasa Main odpowiada za główną pętlę zdarzeń programu oraz komunikacje z użytkownikiem za pomocą konsoli. Jej rozległość jest implikowana relatywnie dużą ilością zależności i wymagań w projekcie.

Komunikacja z programem występuje za pomocą klawiatury i okna konsoli. Warto zwrócić uwagę, że w celu działania na pomieszczeniu trzeba je wcześniej ustawic jako aktywne. Zaleca się korzystanie z programu w następującej kolejności: 
A) Wybranie aktywnej osoby, 2) Wyświetlenie wolnych pomieszczeń wraz z nazwami 3) Wynajęcie wolnego pomieszczenia 4) Ustawienie jednego z wynajętych pomieszczeń jako aktywnego 5) Reszta działań 
W razie wątpliwości, należy wybrać opcję "0", powodującą wyświetlenie instrukcji.



Jako dodatkowe źródło należy traktować graficzne opisanie zależności między klasami dołączone do tego repozytorium.
