package com.example.lab3;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

/**
 * AffichageActivityMouad - Écran de récapitulatif des données.
 * Développé par Mouad Charraj (Z3R0-XR7).
 * Lab 3 - Android Development.
 */
public class AffichageActivityMouad extends AppCompatActivity {

    // Composants UI avec identification personnalisée 'mouad'
    private TextView recap_mouad;
    private Button btnRetour_mouad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Liaison avec le layout XML personnalisé
        setContentView(R.layout.activity_affichage_mouad);

        // Initialisation des vues par Mouad
        recap_mouad = findViewById(R.id.recap_mouad);
        btnRetour_mouad = findViewById(R.id.btnRetour_mouad);

        // Récupération sécurisée du messager (Intent)
        Intent intent_mouad = getIntent();

        // Extraction des métadonnées envoyées par MainActivity
        String nom_data     = intent_mouad.getStringExtra("nom");
        String email_data   = intent_mouad.getStringExtra("email");
        String phone_data   = intent_mouad.getStringExtra("phone");
        String adresse_data = intent_mouad.getStringExtra("adresse");
        String ville_data   = intent_mouad.getStringExtra("ville");

        // Formatage du rendu final (Style Z3R0-XR7)
        StringBuilder sb_mouad = new StringBuilder();
        sb_mouad.append("Utilisateur : ").append(clean(nom_data)).append("\n")
               .append("Contact : ").append(clean(email_data)).append("\n")
               .append("Téléphone : ").append(clean(phone_data)).append("\n")
               .append("Localisation : ").append(clean(adresse_data)).append(", ").append(clean(ville_data));

        // Affichage du résultat final sur l'écran
        recap_mouad.setText(sb_mouad.toString());

        // Logique de navigation retour
        btnRetour_mouad.setOnClickListener(v -> {
            // Fermeture de l'activité actuelle pour revenir en arrière
            finish();
        });
    }

    /**
     * Méthode utilitaire pour nettoyer les chaînes de caractères.
     * @param input La chaîne à traiter
     * @return La chaîne nettoyée ou un indicateur de vide
     */
    private String clean(String input) {
        if (input == null || input.trim().isEmpty()) {
            return "N/A";
        }
        return input.trim();
    }
}
