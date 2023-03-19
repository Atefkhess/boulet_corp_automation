@aleatoire
Feature: Je souhaite verifier le bouton aleatoire

  @aleatoire_Btn
  Scenario: Verifier le bouton aleatoire sur l application bouletcorp
  
    Given J accede à l application bouletcorp 
    When Je clique sur le bouton Aleatoire
    Then La page change
    And Je trouve les widgets facebook twitter et tumblr
