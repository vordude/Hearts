package com.vordude.hearts;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.vordude.hearts.model.HeartsDeck;
import com.vordude.hearts.model.HeartsHand;
import com.vordude.trike.HandView;

import java.util.List;

public class Game extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        HeartsDeck deck = new HeartsDeck();
        HeartsHand[] hands = new HeartsHand[4];
        hands[0] = new HeartsHand();
        hands[1] = new HeartsHand();
        hands[2] = new HeartsHand();
        hands[3] = new HeartsHand();

        while(deck.getNumberOfCardsRemaining() > 0) {
            hands[0].addCard(deck.dealCard());
            hands[1].addCard(deck.dealCard());
            hands[2].addCard(deck.dealCard());
            hands[3].addCard(deck.dealCard());
        }

        setContentView(R.layout.activity_game_main);

        ListView lv = (ListView) findViewById(R.id.south_hand);
        hands[0].sort();
        List southHand = hands[0].getHand();
        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, southHand);
        lv.setAdapter(arrayAdapter);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.game, menu);
        return true;
    }
    
}
