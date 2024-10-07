(ns lab1.task8.modular)

; Функция для преобразования строки в последовательность цифр
(defn str-digits [s]
  (map #(Character/digit % 10) s))

; Функция для генерации всех последовательностей длиной 13
(defn generate-sequences [coll]
  (partition 13 1 coll))

; Функция для фильтрации последовательностей (убираем те, которые содержат 0)
(defn filter-sequences [sequences]
  (filter #(not (some zero? %)) sequences))

; Функция для нахождения произведения элементов последовательности
(defn product [digits]
  (reduce * digits))

; Основная функция для нахождения максимального произведения
(defn find-max-product-modular [number-string]
  (let [digits (str-digits number-string)
        sequences (generate-sequences digits)
        valid-sequences (filter-sequences sequences)]
    (reduce max (map product valid-sequences))))