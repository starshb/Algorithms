#include <iostream>
#include <string>
#include <vector>

using namespace std;

int getPI_cyp(string& str)
{
    int len = str.length();
    int pre = 0;
    int pos = 1;
    int count = 0;

    while (pos < len)
    {
        if (str[pre] == str[pos])
        {
            ++count;
            ++pre;
            ++pos;
        }
        else
        {
            if (pre > 0 && str[pre - 1] == str[pos])
            {
                ++pos;
                continue;
            }

            pre = 0;
            count = 0;
            ++pos;
        }
    }
    return count;
}


int getPI_example(string& str)
{
    int len = str.length();
    int pre = 0;
    int pos = 1;

    vector<int> table;

    table.resize(len);

    int count = 0;

    for (; pos < len; pos++)
    {
        while (pre > 0 && str[pre] != str[pos])
        {
            pre = table[pre - 1];
        }
        if (str[pre] == str[pos])
        {
            table[pos] = ++pre;
        }
    }

    return table[len - 1];
}


int main()
{
    int len;
    string str;

    cin >> len >> str;
    //cout << len - getPI_cyp(str) << std::endl;
    cout << len - getPI_example(str);

}
