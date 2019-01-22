package com.barnettwong.view_library.emojikeyboard.chat.emoji;

import android.view.KeyEvent;
import android.widget.EditText;


import com.barnettwong.view_library.emojikeyboard.chat.bean.Emojicon;

import java.util.ArrayList;
import java.util.List;

/**
 * emoji显示规则
 *
 * @author kymjs (http://www.kymjs.com/) on 6/8/15.
 */
public enum DisplayRules {

    KJEMOJI0("[微笑]", 0xF0, 0x9F, 0x98, 0x81),
    KJEMOJI1("[微笑]", 0xF0, 0x9F, 0x98, 0x82),
    KJEMOJI2("[微笑]", 0xF0, 0x9F, 0x98, 0x83),
    KJEMOJI3("[微笑]", 0xF0, 0x9F, 0x98, 0x84),
    KJEMOJI4("[微笑]", 0xF0, 0x9F, 0x98, 0x85),
    KJEMOJI5("[微笑]", 0xF0, 0x9F, 0x98, 0x86),
    KJEMOJI6("[微笑]", 0xF0, 0x9F, 0x98, 0x89),
    KJEMOJI7("[微笑]", 0xF0, 0x9F, 0x98, 0x8A),
    KJEMOJI8("[微笑]", 0xF0, 0x9F, 0x98, 0x8B),
    KJEMOJI9("[微笑]", 0xF0, 0x9F, 0x98, 0x8C),
    KJEMOJI10("[微笑]", 0xF0, 0x9F, 0x98, 0x8D),
    KJEMOJI11("[微笑]", 0xF0, 0x9F, 0x98, 0x8F),
    KJEMOJI12("[微笑]", 0xF0, 0x9F, 0x98, 0x92),
    KJEMOJI13("[微笑]", 0xF0, 0x9F, 0x98, 0x93),
    KJEMOJI14("[微笑]", 0xF0, 0x9F, 0x98, 0x94),
    KJEMOJI15("[微笑]", 0xF0, 0x9F, 0x98, 0x96),
    KJEMOJI16("[微笑]", 0xF0, 0x9F, 0x98, 0x98),
    KJEMOJI17("[微笑]", 0xF0, 0x9F, 0x98, 0x9A),
    KJEMOJI18("[微笑]", 0xF0, 0x9F, 0x98, 0x9C),
    KJEMOJI19("[微笑]", 0xF0, 0x9F, 0x98, 0x9D),
    KJEMOJI20("[微笑]", 0xF0, 0x9F, 0x98, 0x9E),
    KJEMOJI21("[微笑]", 0xF0, 0x9F, 0x98, 0xA0),
    KJEMOJI22("[微笑]", 0xF0, 0x9F, 0x98, 0xA1),
    KJEMOJI23("[微笑]", 0xF0, 0x9F, 0x98, 0xA2),
    KJEMOJI24("[微笑]", 0xF0, 0x9F, 0x98, 0xA3),
    KJEMOJI25("[微笑]", 0xF0, 0x9F, 0x98, 0xA4),
    KJEMOJI26("[微笑]", 0xF0, 0x9F, 0x98, 0xA5),
    BACK1("[删除]", 0xf0, 0x9f, 0x94, 0x99),
    KJEMOJI27("[微笑]", 0xF0, 0x9F, 0x98, 0xA8),
    KJEMOJI31("[微笑]", 0xF0, 0x9F, 0x98, 0xAD),
    KJEMOJI32("[微笑]", 0xF0, 0x9F, 0x98, 0xB0),
    KJEMOJI28("[微笑]", 0xF0, 0x9F, 0x98, 0xA9),
    KJEMOJI29("[微笑]", 0xF0, 0x9F, 0x98, 0xAA),
    KJEMOJI30("[微笑]", 0xF0, 0x9F, 0x98, 0xAB),
    KJEMOJI33("[微笑]", 0xF0, 0x9F, 0x98, 0xB1),
    KJEMOJI34("[微笑]", 0xF0, 0x9F, 0x98, 0xB2),
    KJEMOJI35("[微笑]", 0xF0, 0x9F, 0x98, 0xB3),
    KJEMOJI36("[微笑]", 0xF0, 0x9F, 0x98, 0xB5),
    KJEMOJI37("[微笑]", 0xF0, 0x9F, 0x98, 0xB7),
    KJEMOJI38("[微笑]", 0xF0, 0x9F, 0x98, 0x80),
    KJEMOJI39("[微笑]", 0xF0, 0x9F, 0x98, 0x87),
    KJEMOJI41("[微笑]", 0xF0, 0x9F, 0x98, 0x8E),
    KJEMOJI42("[微笑]", 0xF0, 0x9F, 0x98, 0x90),
    KJEMOJI43("[微笑]", 0xF0, 0x9F, 0x98, 0x91),
    KJEMOJI44("[微笑]", 0xF0, 0x9F, 0x98, 0x95),
    KJEMOJI45("[微笑]", 0xF0, 0x9F, 0x98, 0x97),
    KJEMOJI46("[微笑]", 0xF0, 0x9F, 0x98, 0x99),
    KJEMOJI47("[微笑]", 0xF0, 0x9F, 0x98, 0x9B),
    KJEMOJI48("[微笑]", 0xF0, 0x9F, 0x98, 0x9F),
    KJEMOJI49("[微笑]", 0xF0, 0x9F, 0x98, 0xA6),
    KJEMOJI50("[微笑]", 0xF0, 0x9F, 0x98, 0xA7),
    KJEMOJI51("[微笑]", 0xF0, 0x9F, 0x98, 0xAC),
    KJEMOJI52("[微笑]", 0xF0, 0x9F, 0x98, 0xAE),
    KJEMOJI53("[微笑]", 0xF0, 0x9F, 0x98, 0xAF),
    KJEMOJI54("[微笑]", 0xF0, 0x9F, 0x98, 0xB4),
    BACK2("[删除]", 0xf0, 0x9f, 0x94, 0x99),
    KJEMOJI55("[微笑]", 0xF0, 0x9F, 0x98, 0xB6),

    CAT1("[微笑]", 0xF0, 0x9F, 0x98, 0xB8),
    CAT2("[微笑]", 0xF0, 0x9F, 0x98, 0xB9),
    CAT3("[微笑]", 0xF0, 0x9F, 0x98, 0xBA),
    CAT4("[微笑]", 0xF0, 0x9F, 0x98, 0xBB),
    CAT5("[微笑]", 0xF0, 0x9F, 0x98, 0xBC),
    CAT6("[微笑]", 0xF0, 0x9F, 0x98, 0xBD),
    CAT7("[微笑]", 0xF0, 0x9F, 0x98, 0xBE),
    CAT8("[微笑]", 0xF0, 0x9F, 0x98, 0xBF),
    CAT9("[微笑]", 0xF0, 0x9F, 0x99, 0x80),
    BACK3("[删除]", 0xf0, 0x9f, 0x94, 0x99);

    private String emojiStr;
    private byte value1;
    private byte value2;
    private byte value3;
    private byte value4;
    private byte[] value;

    DisplayRules(String emojiStr, int value1, int value2, int value3, int value4) {
        this.emojiStr = emojiStr;
        this.value1 = (byte) value1;
        this.value2 = (byte) value2;
        this.value3 = (byte) value3;
        this.value4 = (byte) value4;
        this.value = new byte[]{
                this.value1, this.value2, this.value3, this.value4
        };
    }

    public static boolean isDeleteEmojicon(Emojicon emoji) {
        if (emoji != null && emoji.getCode() != null) {
            byte[] codes = emoji.getCode();
            return (codes[0] == (byte) 0xf0 && codes[1] == (byte) 0x9f && codes[2] == (byte) 0x94
                    && codes[3] == (byte) 0x99);
        } else {
            return false;
        }
    }

    public static List<Emojicon> getAllByType() {
        List<Emojicon> datas = new ArrayList<Emojicon>(values().length);
        for (DisplayRules data : values()) {
            Emojicon emoji = new Emojicon();
            emoji.setCode(data.value);
            emoji.setName(data.emojiStr);
            datas.add(emoji);
        }
        return datas;
    }

    public static void backspace(EditText editText) {
        if (editText == null) {
            return;
        }
        KeyEvent event = new KeyEvent(0, 0, 0, KeyEvent.KEYCODE_DEL, 0, 0, 0,
                0, KeyEvent.KEYCODE_ENDCALL);
        editText.dispatchKeyEvent(event);
    }
}
