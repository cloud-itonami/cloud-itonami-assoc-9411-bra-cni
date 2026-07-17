(ns association.facts
  "Industry rule/history catalog for the Confederação Nacional da
  Indústria (CNI, National Confederation of Industry, Brazil) -- a
  50th industry-association-level source (see
  cloud-itonami-assoc-9411-sau-fsc, -9411-aut-wko, -9411-irl-ibec,
  -9411-nzl-businessnz, -9411-cze-spcr, -9411-ind-cii, -9411-zaf-busa
  for the first seven) per ADR-2607141700
  (cloud-itonami-compliance-fact-federation). The EIGHTH entry
  aligned to ISIC 9411 (activities of business, employers, and
  professional membership organizations). Fills Brazil's
  previously-open association-axis gap (one of the 20-country gap
  list recorded at tick 142) -- Brazil now has real, individually
  verified facts across ALL THREE axes (country:
  cloud-itonami-iso3166-bra statute.facts; municipality:
  cloud-itonami-municipality-bra-sao-paulo; association: this
  entry).

  Both entries directly WebFetch-verified against the FGV CPDOC
  (Centro de Pesquisa e Documentação de História Contemporânea do
  Brasil, part of Fundação Getulio Vargas -- a leading Brazilian
  academic archive of contemporary history) dictionary entry
  (https://www18.fgv.br/cpdoc/acervo/dicionarios/verbete-tematico/confederacao-nacional-da-industria-cni),
  which quotes verbatim: 'criada em 12 de agosto de 1938 e
  reconhecida por carta do Ministério do Trabalho, Indústria e
  Comércio em 17 de setembro do mesmo ano' (created 12 August 1938,
  recognized by the Ministry of Labor, Industry and Commerce on 17
  September of the same year) and, on its predecessor: 'Foi
  precedida pela Confederação Industrial do Brasil, fundada em
  1933' ... '25 de janeiro de 1933' (preceded by the Confederação
  Industrial do Brasil, founded 25 January 1933, in Rio de Janeiro).
  cni.portaldaindustria.com.br's own institutional page renders
  successfully but does not surface this founding-history detail on
  the page checked. No dedicated Wikidata 'inception' statement was
  found for CNI (Q1125075 exists but lacks that property) -- noted
  transparently rather than fabricating a corroboration. No personal
  names of office-holders (e.g. any founding president) are
  persisted here.

  An association not in `catalog` has NO spec-basis, full stop; never
  fabricate one.")

(def catalog
  "association-slug -> vector of association-rule entries."
  {"cni"
   [{:association-rule/id "cni.predecessor-cib-1933"
     :association-rule/title "Confederação Industrial do Brasil (CIB), CNI's direct predecessor, founded 25 January 1933 in Rio de Janeiro (FGV CPDOC official historical dictionary)"
     :association-rule/association "cni"
     :association-rule/isic "9411"
     :association-rule/country "BRA"
     :association-rule/kind :governance-program
     :association-rule/url "https://www18.fgv.br/cpdoc/acervo/dicionarios/verbete-tematico/confederacao-nacional-da-industria-cni"
     :association-rule/url-provenance :fgv-cpdoc-corroborated
     :association-rule/established-date "1933-01-25"
     :association-rule/retrieved-at "2026-07-17"
     :association-rule/topic #{:governance}}
    {:association-rule/id "cni.founding-1938"
     :association-rule/title "Confederação Nacional da Indústria (CNI) created 12 August 1938, recognized by the Ministry of Labor, Industry and Commerce on 17 September 1938, succeeding the Confederação Industrial do Brasil (FGV CPDOC official historical dictionary)"
     :association-rule/association "cni"
     :association-rule/isic "9411"
     :association-rule/country "BRA"
     :association-rule/kind :governance-program
     :association-rule/url "https://www18.fgv.br/cpdoc/acervo/dicionarios/verbete-tematico/confederacao-nacional-da-industria-cni"
     :association-rule/url-provenance :fgv-cpdoc-corroborated
     :association-rule/established-date "1938-08-12"
     :association-rule/retrieved-at "2026-07-17"
     :association-rule/topic #{:governance}}]})

(defn spec-basis [association] (get catalog association))

(defn coverage
  ([] (coverage (keys catalog)))
  ([associations]
   (let [have (filter catalog associations)
         missing (remove catalog associations)]
     {:requested (count associations)
      :covered (count have)
      :covered-associations (vec (sort have))
      :missing-associations (vec (sort missing))
      :note (str "cloud-itonami-assoc-9411-bra-cni Wave 0 (ADR-2607141700): "
                 (count (get catalog "cni")) " CNI entries seeded "
                 "with FGV CPDOC official historical dictionary corroboration "
                 "(cni.portaldaindustria.com.br's own page renders but lacks founding-history text). "
                 "Extend `association.facts/catalog`, never fabricate an id/url.")})))

(defn by-topic [association topic]
  (filterv #(contains? (:association-rule/topic %) topic) (spec-basis association)))
