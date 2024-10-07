(ns lab1.task8.tail)

; Преобразует строку в список цифр
(defn str-digits [s]
  (map #(Character/digit % 10) s))

; Вычисляет произведение цифр в последовательности
(defn product [digits acc]
  (if (empty? digits)
    acc
    (recur (rest digits) (* acc (first digits)))))

; Находит максимальное произведение среди всех возможных подряд идущих групп из 13 цифр
(defn find-max-product-tail-rec [nums]
  (loop [parts (partition 13 1 (str-digits nums))
         max-prod 0]
    (if (empty? parts)
      max-prod
      (let [current-prod (product (first parts) 1)]
        (recur (rest parts) (max max-prod current-prod))))))